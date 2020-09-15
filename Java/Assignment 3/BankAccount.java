/*
    Assignment #3 by Andy Me
*/
abstract class BankAccount extends Investment
{
	String accountNumber;
	public BankAccount()
	{
		super();
		setAccountNumber("none");
	}
	public BankAccount(String newType, String newName, String newAccount)
	{
		super(newType, newName);
		setAccountNumber(newAccount);
	}
	public void setAccountNumber(String newAcc)
	{
		this.accountNumber = newAcc;
	}
	public String getAccountNumber()
	{
		return this.accountNumber;
	}
	public String toString()
	{
		String output = String.format("%s Account Number: %s", super.toString(), accountNumber);
		return output;
	}
}