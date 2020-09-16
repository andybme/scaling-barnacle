import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
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
	
	public Portfolio(String portfolioName, int seed)
	{
		this.portfolioName = portfolioName;
		randy = new Random(seed);
	}
	public void initializePortfolio() throws IOException
	{
		System.out.printf("Please enter name of file to read the portfolio from: ");
		String inputFileName=keyboard.next();		
		File inputFile = new File(inputFileName); 		
		if(!inputFile.exists())
		{
			System.out.printf("Input File %s was not found.\n", inputFileName);
			System.exit(0);
		}
		Scanner inputReader = new Scanner(inputFile);
		
		// Some temporary variables
		String type, name;
		double pricePerShare, numSharesOwned; 	
		Stock myStock;
		double pricePerBond, annualReturnPercentage;
		int numBondsOwned;
		Bond myBond;
		String accountNumber;
		double initialDeposit, annualInterestRatePercent;
		SavingsAccount mySavingsAccount;
		double minimumCheckFreeBalance, checkCharge;
		CheckingAccount myCheckingAccount;
		
		//Initialize the portfolio
		while(inputReader.hasNext())
		{
			type = inputReader.next();
			if (type.equalsIgnoreCase("Stock"))
			{
				name = inputReader.next();
				pricePerShare = inputReader.nextDouble();
				numSharesOwned = inputReader.nextDouble();
				myStock = new Stock(name, pricePerShare, numSharesOwned);
				portfolioInvestments.add(myStock);
				
			}
			else if(type.equalsIgnoreCase("Bond"))
			{
				name = inputReader.next();
				pricePerBond = inputReader.nextDouble();
				numBondsOwned = inputReader.nextInt();
				annualReturnPercentage = inputReader.nextDouble();
				myBond = new Bond(name, pricePerBond, numBondsOwned, annualReturnPercentage);
				portfolioInvestments.add(myBond);
			}
			else if(type.equalsIgnoreCase("SavingsAccount"))
			{
				name = inputReader.next();
				accountNumber = inputReader.next();
				initialDeposit = inputReader.nextDouble();
				annualReturnPercentage = inputReader.nextDouble();
				mySavingsAccount = new SavingsAccount(name, accountNumber, initialDeposit, annualReturnPercentage);
				portfolioInvestments.add(mySavingsAccount);
			}
			else if(type.equalsIgnoreCase("CheckingAccount"))
			{
				name = inputReader.next();
				accountNumber = inputReader.next();
				initialDeposit = inputReader.nextDouble();
				annualReturnPercentage = inputReader.nextDouble();
				minimumCheckFreeBalance = inputReader.nextDouble();
				checkCharge = inputReader.nextDouble();
				myCheckingAccount = new CheckingAccount(name, accountNumber, initialDeposit, annualReturnPercentage, minimumCheckFreeBalance, checkCharge);
				portfolioInvestments.add(myCheckingAccount);
			}
		}
		
		inputReader.close();
	}
	public void modelPortfolio(int months)
	{
		// Some temporary variables
		Stock stockItem;
		Bond bondItem;
		SavingsAccount savingsItem;
		CheckingAccount checkingItem;
		double priceChangePercent, priceChange, dividendPercent, savingsTransaction, checkDeposit, checkValue;
		for(int i = 1; i <= months; i++)
		{
			for (Investment investItem : portfolioInvestments)
			{
				if(investItem instanceof Stock) //handle Stocks For Each Month
				{
					stockItem = (Stock)investItem;
					// Randomly pick price change between -10 to +20 percent by tenths every three months
					if(months%3 == 0)
					{
						priceChangePercent = (randy.nextInt(301) -100)/10.0;
						priceChange = (stockItem.getPricePerShare() * priceChangePercent)/100.0;
						//Randomly pick a dividend from 0 to 5 percent by tenths
						dividendPercent = randy.nextInt(51)/10.0;
						stockItem.calcStockValues(priceChange, dividendPercent);
					}
				}
				
				else if(investItem instanceof Bond) //Bond growth
				{
					bondItem = (Bond)investItem;
					bondItem.calcBondValues(); 
				}
				
				else if(investItem instanceof SavingsAccount) //SavingsAccount Activity
				{
					savingsItem = (SavingsAccount)investItem;
					// Have 3 transactions per month with withdrawals and deposits ranging from -$600 to +$1000 
					for (int k = 0; k < 3; k++)
					{
						savingsTransaction = (randy.nextInt(160001) -60000)/100.0;
						if(savingsTransaction > 0.0)
							savingsItem.makeDeposit(savingsTransaction);
						else if(savingsTransaction < 0.0)
							savingsItem.makeWithdrawal(savingsTransaction);
					}
					savingsItem.calcValue();
				}
				
				else if(investItem instanceof CheckingAccount) //CheckingAccount Activity
				{
					checkingItem = (CheckingAccount)investItem;
					//Make 1 deposit a month betwee $500 and $1500 to nearest ten cents
					checkDeposit = (randy.nextInt(10001) +5000)/10.0;
					checkingItem.makeDeposit(checkDeposit);
					// write 4 checks per month of bewtween 10 and 300 dollars, to the nearest penny
					for(int k = 0; k < 4; k++)
					{
						checkValue = (randy.nextInt(29001) +1000)/100.0;
						checkingItem.writeCheck(checkValue);
					}
					checkingItem.calcValue();					
				}
			}
		}
	}
	public void generatePortfolioReport(int months) throws IOException
	{
		double totalValueOfAllInvestments = 0.0;
		System.out.printf("Please enter name of file to write portfolio results to: ");
		String outputFileName=keyboard.next();
		File outputFile = new File (outputFileName);
		PrintWriter outputWriter = new PrintWriter(outputFile);
		
		outputWriter.printf("Results of the portfolio %s over %d months\n", portfolioName, months);
		for(Investment invest : portfolioInvestments)
		{
			outputWriter.printf("%s\n", invest);
			totalValueOfAllInvestments  = totalValueOfAllInvestments + invest.getInvestmentValue();
		}
		outputWriter.printf("\nThe total value of all the investments is $%4.2f\n", totalValueOfAllInvestments);
		outputWriter.close();
		
	}
}