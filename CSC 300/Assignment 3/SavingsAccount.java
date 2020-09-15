/*
    Assignment #3 by Andy Me
*/
public class SavingsAccount extends BankAccount
{
	private double annualInterestRatePercent;
	private double rate;
	private double totalInterestEarned;
	public SavingsAccount()
	{
		super();
	}
	public SavingsAccount(String newName, String newAcc, double initialDeposit, double newPerc)
	{
		super("SavingsAccount", newName, newAcc);
		super.setInvestmentValue(initialDeposit);
		setAnnualInterestRatePercent(newPerc);
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
	public void makeWithdrawal(double withdrawal)
	{
		if(withdrawal > getInvestmentValue())
		{
			System.out.println("Insufficient Funds for Withdrawal");
			return;
		}
		setInvestmentValue(getInvestmentValue() - withdrawal);
	}
	public void calcValue()
	{
		double tempInterest = (rate/12) * getInvestmentValue();
		setInvestmentValue(getInvestmentValue() + tempInterest);
		totalInterestEarned += tempInterest;
	}
	public String toString()
	{
		String output = String.format("%s\nCurrent Value: $%.2f Interest Earned: $%.2f", super.toString(), super.getInvestmentValue(), totalInterestEarned);
		return output;
	}
}