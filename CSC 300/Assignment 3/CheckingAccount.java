/*
    Assignment #3 by Andy Me
*/
public class CheckingAccount extends BankAccount
{
	private double minimumCheckFreeBalance;
	private double annualInterestRatePercent;
	private double checkCharge;
	private double totalCheckCharges;
	private double totalInterestEarned;
	private double rate;
	public CheckingAccount()
	{
		super();
	}
	public CheckingAccount(String newName, String newAcc, double initialDeposit, double newPerc, double newMin, double newCharge)
	{
		super("CheckingAccount", newName, newAcc);
		super.setInvestmentValue(initialDeposit);
		setAnnualInterestRatePercent(newPerc);
		setMinimumCheckFreeBalance(newMin);
		setCheckCharge(newCharge);
		setTotalCheckCharges(0.0);
	}
	public void setMinimumCheckFreeBalance(double min)
	{
		this.minimumCheckFreeBalance = min;
	}
	public void setCheckCharge(double charge)
	{
		this.checkCharge = charge;
	}
	public double getCheckCharge()
	{
		return this.checkCharge;
	}
	public void setTotalCheckCharges(double total)
	{
		this.totalCheckCharges = total;
	}
	public void setAnnualInterestRatePercent(double newPerc)
	{
		this.annualInterestRatePercent = newPerc;
		this.rate = newPerc / 100.0;
	}
	public void setTotalInterestEarned(double newInterest)
	{
		this.totalInterestEarned = newInterest;
	}
	public double getAnnualInterestRatePercent()
	{
		return this.annualInterestRatePercent;
	}
	public double getTotalInterestEarned()
	{
		return this.totalInterestEarned;
	}
// methods
	public void makeDeposit(double deposit)
	{
		setInvestmentValue(getInvestmentValue() + deposit);
	}
	public void writeCheck(double check)
	{
		if(check > getInvestmentValue())
		{
			System.out.println("Insufficient Funds for Withdrawal");
			return;
		}else if((getInvestmentValue() - check) < minimumCheckFreeBalance)
		{
			setInvestmentValue(getInvestmentValue() - checkCharge);
			totalCheckCharges += checkCharge;
		}
		setInvestmentValue(getInvestmentValue() - check);
	}
	public void calcValue()
	{
		double tempInterest = (rate/12) * getInvestmentValue();
		setInvestmentValue(getInvestmentValue() + tempInterest);
		totalInterestEarned += tempInterest;
	}
	public String toString()
	{
		String output = String.format("%s\nMinimum For Free Checking: $%.2f Check Charge: $%.2f\nCurrent Value: $%.2f Interest Earned: $%.2f Check Charges: $%.2f\n", super.toString(), minimumCheckFreeBalance, checkCharge, super.getInvestmentValue(), totalInterestEarned, totalCheckCharges);
		return output;
	}
}