/*
    Assignment #2 by Andy Me
*/

public class Quadratic
{
    int a, b, c = 0;
    double c1real, c2real;
    double discriminant;
    public Quadratic(int a1, int b1, int c1)
    {
        a = a1;
        b = b1;
        c = c1;
        discriminant = ((b*b) - (4*a*c));
    }
    public ComplexPair solveQuadratic()
    {
        if(a == 0)
        {
            c1real = c2real = (-1 * c / b);
            discriminant = 0;
        }else if(discriminant >= 0)
        {
            c1real = (-b + Math.sqrt((b*b) - (4*a*c)))/(2*a);
            c2real = (-b - Math.sqrt((b*b) - (4*a*c)))/(2*a);
            discriminant = 0;
        } else
        {
            c1real = c2real = (-b / (2*a));
        }

        Complex c1 = new Complex(c1real, discriminant);
        Complex c2 = new Complex(c2real, -1*discriminant);
        ComplexPair answer = new ComplexPair(c1, c2);

        System.out.println(c1);

        return answer;
    }
    public String getComment()
    {

        if(a == 0)
        {
            if(b == 0)
            {
                return "Linear equation: no real roots";
            } else
            {
                return "Linear equation: one real root";
            }

        } else if(discriminant == 0)
        {
            if(c1real == c2real)
            {
                return "Quadratic equation: one real root";
            } else 
            {
                return "Quadratic equation: two real roots";
            }
        } else
        {
            return "Quadratic equation: two imaginary roots";
        }

    }
    public String toString()
    {
        String answer = String.format("%dx^2 + %dx + %d = 0", a, b, c);
        return answer;
    }
}