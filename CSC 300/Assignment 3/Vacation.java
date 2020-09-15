/*
    Assignment #3 by Andy Me
*/
import java.lang.IllegalArgumentException;

abstract class Vacation
{
	private String destination;
	private double budget;
	public Vacation(String d, double b)
	{
		setDestination(d);
		setBudget(b);
	}
	public void setDestination(String d)
	{
		this.destination = d;
	}
	public void setBudget(double b) throws IllegalArgumentException
	{
		if (b < 0) throw new IllegalArgumentException("Budget must be >= 0.0");
		this.budget = b;
	}
	public String getDestination()
	{
		return this.destination;
	}
	public double getBudget()
	{
		return this.budget;
	}
	public String toString()
	{
		String answer = String.format("Destination: %s; Budget: $%.2f", this.destination, this.budget);
		return answer;
	}
	public boolean equals(Vacation vac)
	{
		if(Math.abs(vac.budget - this.budget) <= 0.001) return true;
		return false;
	}
	abstract double overBudget();
}