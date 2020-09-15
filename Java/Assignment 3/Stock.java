/*
    Assignment #3 by Andy Me
*/
public class Stock extends Investment
{
	private double pricePerShare;
	private double numOfSharesOwned;
	private double dividendsEarnedToDate;
	public Stock(){
		super();
	}
	public Stock(String newName, double newPrice, double newNum){
		super("Stock", newName);
		setPricePerShare(newPrice);
		setNumOfSharesOwned(newNum);
		super.setInvestmentValue(newPrice * newNum);
	}
	public void setPricePerShare(double newPrice){
		this.pricePerShare = newPrice;
	}
	public void setNumOfSharesOwned(double newNum){
		this.numOfSharesOwned = newNum;
	}
	public double getPricePerShare(){
		return pricePerShare;
	}
	public double getNumOfSharesOwned(){
		return numOfSharesOwned;
	}
	//methods
	public void calcStockValues(double priceChange, double dividendPercent){
		pricePerShare += priceChange;
		double currentDividend = pricePerShare*dividendPercent/100.0;
		dividendsEarnedToDate += currentDividend;
		while(currentDividend >= pricePerShare){
			numOfSharesOwned++;
			currentDividend = currentDividend - pricePerShare;
		}
		setInvestmentValue(pricePerShare*numOfSharesOwned);
	}
	public String toString(){
		String output = String.format("%s\nPrice Per Share: $%.2f Number of Shares: %.2f\nCurrent Value: $%.2f Investment Earnings to date: %.2f", super.toString(), pricePerShare, numOfSharesOwned, super.getInvestmentValue(), dividendsEarnedToDate);
		return output;
	}
}