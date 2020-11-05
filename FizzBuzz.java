/* FizzBuzz by Andy

*/
import java.lang.StringBuffer;
import java.util.Scanner;

public class FizzBuzz
{
	public static void main(String[] args)
	{
		int number = 1;
		StringBuffer answer = new StringBuffer(8);
		Scanner input = new Scanner(System.in);
		while (number != 0)
		{
			System.out.println("Please input an integer to test: (0 to quit)");
			number = input.nextInt();
			answer.delete(0, 9);
			if ((number % 3) == 0) answer = answer.append("Fizz");
			if ((number % 5) == 0) answer = answer.append("Buzz");
			if (answer.length() == 0) answer.append(number);
			System.out.printf("%s\n", answer);
		}
	}
}