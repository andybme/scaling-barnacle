/*
    Assignment #6 by Andy Me
*/
import java.util.Scanner;

public class IsEqualToTest
{
	public static <T> boolean isEqualTo(T a, T b)
	{
		return a.equals(b);
	}

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter two integers: ");
		Integer int1 = input.nextInt();
		Integer int2 = input.nextInt();
		System.out.println("Please enter two Strings: ");
		String string1 = input.next();
		String string2 = input.next();
		System.out.println("Please enter two doubles: ");
		Double db1 = input.nextDouble();
		Double db2 = input.nextDouble();
		Object obj1 = new Object();
		Object obj2 = new Object();
		System.out.println(isEqualTo(int1, int2));
		System.out.println(isEqualTo(string1, string2));
		System.out.println(isEqualTo(db1, db2));
		System.out.println(isEqualTo(obj1, obj2));

	}
}