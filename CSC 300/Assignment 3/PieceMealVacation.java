/*
    Assignment #3 by Andy Me
*/
import java.lang.IllegalArgumentException;
import java.lang.StringBuilder;
import java.util.Arrays;

public class PieceMealVacation extends Vacation
{
	private String[] items;
	private double[] costs;

	public PieceMealVacation(String d, double b, String[] it, double[] c)
	{
		super(d, b);
		setItems(it);
		setCosts(c);
	}
	public void setItems(String[] it)
	{
		items = it;
	}
	public void setCosts(double[] c)
	{
		costs = Arrays.copyOf(c, this.items.length);
	}
	public String[] getItems()
	{
		return this.items;
	}
	public double[] getCosts()
	{
		return this.costs;
	}
	public String toString()
	{
		StringBuilder it = new StringBuilder(super.toString());
		for (int i=0; i<this.costs.length; i++)
		{
			String temp = String.format("\n%s: $%.2f", items[i], costs[i]);
			it.append(temp);
		}
		return it.toString();
	}
	public boolean equals(PieceMealVacation vac)
	{
		if(!super.equals(vac)) return false;
		for (int i=0; i<this.costs.length; i++)
		{
			if(!(Math.abs(this.costs[i] - vac.costs[i]) <= 0.001)) return false;
			if(this.items[i] != vac.items[i]) return false;
		}
		return true;
	}
	public double overBudget()
	{
		double sum = 0;
		for (double c : this.costs)
		{
			sum += c;
		}
		return (super.getBudget() - sum);
	}
}