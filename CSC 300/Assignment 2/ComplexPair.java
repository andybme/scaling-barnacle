/*
    Assignment #2 by Andy Me
*/

public class ComplexPair
{
	public Complex ca1 = new Complex(0, 0);
	public Complex ca2 = new Complex(0, 0);
	public ComplexPair(Complex co1, Complex co2)
	{
		this.ca1 = new Complex (co1.real, co1.imaginary);
		this.ca2 = new Complex (co2.real, co2.imaginary);
	}
	public boolean bothIdentical()
	{
		if (ca1.real != ca2.real) return false;
		if (ca1.imaginary != ca2.imaginary) return false;
		return true;
	}
	public String toString()
    {
    	String answer;
		answer = String.format("%.2f", ca1.real );
    	answer = String.format("first: %s; second: %s", ca1, ca2);
    	return answer;
    }
    public Complex getCa1()
    {
    	return this.ca1;
    }
    public Complex getCa2()
    {
    	return this.ca2;
    }
    public void setCa2(Complex co2)
    {
    	this.ca2 = co2;
    }
    public void setCa1(Complex co1)
    {
    	this.ca1 = co1;
    }
}