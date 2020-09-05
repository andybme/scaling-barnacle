/*
    Assignment #2 by Andy Me

*/

public class ComplexPair
{
	public Complex ca1;
	public Complex ca2;
	public ComplexPair(Complex co1, Complex co2)
	{
		Complex ca1 = new Complex (co1.real, co1.imaginary);
		System.out.println("p1 success");
		Complex ca2 = new Complex (co2.real, co2.imaginary);
		System.out.println("p2 success");
	}
	public boolean bothIdentical()
	{
		if (ca1.real != ca2.real) return false;
		if (ca1.imaginary != ca2.imaginary) return false;
		return true;
	}
	public String toString()
    {
    	String answer, answer1, answer2;


		System.out.println(ca1);
    	answer = "Yahhhhh";
    	return answer;
    }
}