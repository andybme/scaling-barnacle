/*
    Assignment #2 by Andy Me
*/

public class Complex
{
    public double real, imaginary = 0;
    public Complex(double realComp, double imaginaryComp)
    {
        real = realComp;
        imaginary = imaginaryComp;
    }
    public boolean isReal()
// whether or not a number is complex or not is encoded in the imaginary part
// 0 is real, any other number would be the imaginary component
    {
        if (imaginary == 0) return true;
        return false;
    }
    public String toString()
    {
        String answer = String.format("%.2f", real );
        if (imaginary == 0) return answer;
        answer = answer + String.format(" " + Double.toString(imaginary));
        return answer;
    }
}