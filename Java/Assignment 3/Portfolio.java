/*
    Assignment #3 by Andy Me
*/
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.io.FileNotFoundException;

public class Portfolio
{
	private String portfolioName;
	private ArrayList<Investment> portfolioInvestments = new ArrayList<Investment>();
	private Random randy;
	public Scanner keyboard = new Scanner(System.in);
	public Portfolio()
	{
		portfolioName = "none";
	}
	public Portfolio(String name, int seed)
	{
		portfolioName = name;
		Random randy = new Random(seed);
	}
	public void initializePortfolio() throws FileNotFoundException
	{
		System.out.print("Input file name: ");
		String inputFileName = keyboard.nextLine();
		File inputFile = new File(inputFileName);
		Scanner scanInputFile = new Scanner(inputFile);
		String name;
		int number;
		String accountNumber;
		double price;
		double percent;
		double initial;
		double min;
		double charge;
		while (scanInputFile.hasNextLine())
		{
			String investmentType = scanInputFile.next();
			switch(investmentType)
			{
				case "Stock":
				name = scanInputFile.next();
				price = scanInputFile.nextDouble();
				number = scanInputFile.nextInt();
				Stock newStock = new Stock(name, price, number);
				portfolioInvestments.add(newStock);
				case "Bond":
				name = scanInputFile.next();
				price = scanInputFile.nextDouble();
				number = scanInputFile.nextInt();
				percent = scanInputFile.nextDouble();
				Bond newBond = new Bond(name, price, number, percent);
				portfolioInvestments.add(newBond);
				case "SavingsAccount":
				name = scanInputFile.next();
				accountNumber = scanInputFile.next();
				initial = scanInputFile.nextDouble();
				percent = scanInputFile.nextDouble();
				SavingsAccount newSavings = new SavingsAccount(name, accountNumber, initial, percent);
				portfolioInvestments.add(newSavings);
				case "CheckingAccount":
				name = scanInputFile.next();
				accountNumber = scanInputFile.next();
				initial = scanInputFile.nextDouble();
				percent = scanInputFile.nextDouble();
				min = scanInputFile.nextDouble();
				charge = scanInputFile.nextDouble();
				CheckingAccount newChecking = new CheckingAccount(name, accountNumber, initial, percent, min, charge);
				portfolioInvestments.add(newChecking);
			}
		}
	}
	/*public void modelPortfolio(int months)
	{
		for (int i = 0; i < months; i++)
		{
			for(Investments investment : portfolioInvestments)
			{
				switch(investment.getType())
				{
					case "Stock":
					double priceChange = ((randy.nextDouble() % 30) / 100) - .10;
					investment.
				}
			}
		}
	}*/
}