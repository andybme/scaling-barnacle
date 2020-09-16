/*
    Assignment #3 by Andy Me
*/
public class Bond extends Investment
{
	private double pricePerBond;
	private double annualReturnPercentage;
	private double rate;
	private double cashEarnedToDate;
	private int numOfBondsOwned;
	public Bond()
	{
		super();
	}
	public Bond(String newName, double newPrice, int newNum, double newPerc)
	{
		super("Bond", newName);
		setPricePerBond(newPrice);
		setNumOfBondsOwned(newNum);
		setAnnualReturnPercentage(newPerc);
		setInvestmentValue(newPrice * newNum);
	}
	public void setPricePerBond(double newPrice)
	{
		this.pricePerBond = newPrice;
	}
	public void setNumOfBondsOwned(int newNum)
	{
		this.numOfBondsOwned = newNum;
	}
	public void setAnnualReturnPercentage(double newPerc)
	{
		this.rate = (newPerc / 12 / 100.0);
		this.annualReturnPercentage = newPerc;
	}
	public double getPricePerBond()
	{
		return pricePerBond;
	}
	public int getNumOfBondsOwned()
	{
		return numOfBondsOwned;
	}
	public double getAnnualReturnPercentage()
	{
		return annualReturnPercentage;
	}
	//methods
	public void calcBondValues()
	{
		cashEarnedToDate += (rate * pricePerBond * numOfBondsOwned);
		setInvestmentValue(cashEarnedToDate + (pricePerBond * numOfBondsOwned));
	}
	public String toString()
	{
		String output = String.format("%s\nPrice Per Bond: $%.2f Number of Bonds: %d\nCurrent Value: $%.2f Cash On Hand To Date: $%.2f\n", super.toString(), pricePerBond, numOfBondsOwned, super.getInvestmentValue(), cashEarnedToDate);
		return output;
	}
}