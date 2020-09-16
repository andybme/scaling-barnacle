/*
    Assignment #3 by Andy Me
*/
import java.util.Scanner;
import java.io.IOException;

public class TestPortfolioManager
{
	public static void main(String[]args) throws IOException
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Portfolio Name: ");
		String portfolioName = keyboard.nextLine();
		System.out.print("Seed: ");
		int seed = keyboard.nextInt();
		Portfolio test1 = new Portfolio(portfolioName, seed);
		test1.initializePortfolio();
		System.out.print("Months: ");
		int months = keyboard.nextInt();
		test1.modelPortfolio(months);
		test1.generatePortfolioReport(months);
	}
}
