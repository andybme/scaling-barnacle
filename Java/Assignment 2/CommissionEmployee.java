/*
    Assignment #2 by Andy Me
*/
import java.lang.IllegalArgumentException;

public class CommissionEmployee
{
	private final String firstName;
	private final String lastName;
	private double grossSales;
	private double commissionPercent;

	public CommissionEmployee(String fName, String lName, double gSales, double cPercent)
	{
		this.firstName = fName;
		this.lastName = lName;
		setSales(gSales);
		setPercent(cPercent);
	}
	public void setSales(double gSales) throws IllegalArgumentException
	{
		if (gSales < 0) throw new IllegalArgumentException("Gross sales must be >= 0.0");
		this.grossSales = gSales;
	}
	public void setPercent(double cPercent) throws IllegalArgumentException
	{
		if (cPercent < 0 || cPercent > 100) throw new IllegalArgumentException("Commission rate must be >= 0.0 and <= 100.0");
		this.commissionPercent = cPercent;
	}
	public String getFirst()
	{
		return firstName;
	}
	public String getLast()
	{
		return lastName;
	}
	public double getSales()
	{
		return grossSales;
	}
	public double getPercent()
	{
		return commissionPercent;
	}
	public double earnings()
	{
		return (grossSales * commissionPercent / 100);
	}
	public String toString()
	{
		String answer = String.format("%-11s%-11s$%.2f %.2f%%", firstName, lastName, grossSales, commissionPercent);
		return answer;
	}
	public String getName()
	{
		return String.format("%-11s%-11s", firstName, lastName);
	}
}