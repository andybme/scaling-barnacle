/*
    Assignment #2 by Andy Me
*/
public class BasePlusCommissionEmployee extends CommissionEmployee
{
	private double baseSalary;

	public BasePlusCommissionEmployee(String fName, String lName, double gSales, double cPercent, double bSalary)
	{
		super(fName, lName, gSales, cPercent);
		setSalary(bSalary);
	}
	public void setSalary(double bSalary) throws IllegalArgumentException
	{
		if (bSalary < 0) throw new IllegalArgumentException("Base salary must be >= 0.0");
		this.baseSalary = bSalary;
	}
	public double getSalary()
	{
		return baseSalary;
	}
	public double earnings()
	{
		return (super.earnings() + getSalary());
	}
	public String toString()
	{
		String answer = String.format("%s $%.2", super.toString(), baseSalary);
		return answer;
	}
}