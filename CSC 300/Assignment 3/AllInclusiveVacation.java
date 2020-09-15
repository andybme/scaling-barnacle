/*
    Assignment #3 by Andy Me
*/
import java.lang.IllegalArgumentException;

public class AllInclusiveVacation extends Vacation
{
	private String brand;
	private int rating; // from 1 to 5
	private double price;

	public AllInclusiveVacation(String d, double bu, String br, int r, double p)
	{
		super(d, bu);
		setBrand(br);
		setRating(r);
		setPrice(p);
	}
	public void setBrand(String br)
	{
		this.brand = br;
	}
	public void setRating(int r) throws IllegalArgumentException
	{
		if (r < 1 || r > 5) throw new IllegalArgumentException("Rating must be > 0 and <= 5");
		this.rating = r;
	}
	public void setPrice(double p) throws IllegalArgumentException
	{
		if (p < 0) throw new IllegalArgumentException("Price must be >= 0.0");
		this.price = p;
	}
	public String getBrand()
	{
		return this.brand;
	}
	public int getRating()
	{
		return this.rating;
	}
	public double getPrice()
	{
		return this.price;
	}
	public boolean equals(AllInclusiveVacation vac)
	{
		if(!super.equals(vac)) return false;
		if(!brand.equalsIgnoreCase(vac.getBrand())) return false;
		if(!(Math.abs(vac.getBudget() - super.getBudget()) <= 0.001)) return false;
		return true;
	}
	public String toString()
	{
		String answer = String.format("%s\nBrand: %s; Rating: %d; Price: $%.2f", super.toString(), this.brand, this.rating, this.price);
		return answer;
	}
	public double overBudget()
	{
		return (super.getBudget() - this.price);
	}
}