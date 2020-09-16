/*
    Assignment #3 by Andy Me
*/
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Portfolio
{
    private String portfolioName;
    private ArrayList<Investment> portfolioInvestments = new ArrayList<Investment>();
    private Random randy;
    public Scanner keyboard = new Scanner(System.in);
    int seed;
    public Portfolio()
    {
        portfolioName = "none";
    }
    public Portfolio(String name, int newSeed)
    {
        portfolioName = name;
        Random randy = new Random(seed);
        seed = newSeed;
    }
    public void initializePortfolio() throws FileNotFoundException
    {
        System.out.print("Input file name: ");
        String inputFileName = keyboard.nextLine();
        File inputFile = new File(inputFileName);
        Scanner scanInputFile = new Scanner(inputFile);
        String investmentName;
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
                investmentName = scanInputFile.next();
                price = scanInputFile.nextDouble();
                number = scanInputFile.nextInt();
                Stock newStock = new Stock(investmentName, price, number);
                portfolioInvestments.add(newStock);
                break;
                case "Bond":
                investmentName = scanInputFile.next();
                price = scanInputFile.nextDouble();
                number = scanInputFile.nextInt();
                percent = scanInputFile.nextDouble();
                Bond newBond = new Bond(investmentName, price, number, percent);
                portfolioInvestments.add(newBond);
                break;
                case "SavingsAccount":
                investmentName = scanInputFile.next();
                accountNumber = scanInputFile.next();
                initial = scanInputFile.nextDouble();
                percent = scanInputFile.nextDouble();
                SavingsAccount newSavings = new SavingsAccount(investmentName, accountNumber, initial, percent);
                portfolioInvestments.add(newSavings);
                break;
                case "CheckingAccount":
                investmentName = scanInputFile.next();
                accountNumber = scanInputFile.next();
                initial = scanInputFile.nextDouble();
                percent = scanInputFile.nextDouble();
                min = scanInputFile.nextDouble();
                charge = scanInputFile.nextDouble();
                CheckingAccount newChecking = new CheckingAccount(investmentName, accountNumber, initial, percent, min, charge);
                portfolioInvestments.add(newChecking);
                break;
            }
        }
    }
    public void modelPortfolio(int months)
    {
        Random randy2 = new Random(seed);
        for (int i = 0; i < months; i++)
        {
            for(Investment investment : portfolioInvestments)
            {
                double pricePercentChange;
                double priceChange;
                double percentDividend;
                double savingsTrans;
                double checkingsTrans;
                int j;
                Stock stockItem;
                Bond bondItem;
                SavingsAccount savingsAccountItem;
                CheckingAccount checkingAccountItem;
                switch(investment.getType())
                {
                    case "Stock":
                        stockItem = (Stock)investment;
                        if ((i % 3) > 0)
                        {
                            pricePercentChange = (randy2.nextInt(301) -100)/10.0;
                            priceChange = pricePercentChange / 100 * stockItem.getPricePerShare();
                            percentDividend = (randy2.nextInt(51)/10.0);
                            stockItem.calcStockValues(priceChange, percentDividend);
                        }
                        break;
                    case "Bond":
                            bondItem = (Bond)investment;
                            bondItem.calcBondValues();
                            break;
                    case "SavingsAccount":
                            savingsAccountItem = (SavingsAccount)investment;
                        for(j = 0; j < 3; j++)
                        {
                            savingsTrans = (randy2.nextInt(160001) -60000)/100.0;
                            if (savingsTrans > 0) savingsAccountItem.makeDeposit(savingsTrans);
                            if (savingsTrans < 0) savingsAccountItem.makeWithdrawal(Math.abs(savingsTrans));
                        }
                        savingsAccountItem.calcValue();
                        break;
                    case "CheckingAccount":
                        checkingAccountItem = (CheckingAccount)investment;
                        checkingsTrans = (randy2.nextInt(10001) +5000)/10.0;
                        checkingAccountItem.makeDeposit(checkingsTrans);
                        for (j = 0; j < 4; j++)
                        {
                            checkingsTrans = (randy2.nextDouble() % 290) + 10;
                            checkingAccountItem.writeCheck(checkingsTrans);
                        }
                        checkingAccountItem.calcValue();
                        break;
                }
            }
        }
    }
    public void generatePortfolioReport(int months) throws FileNotFoundException
    {
        System.out.print("Output File Name: ");
        double sum = 0;
        String outFileName = keyboard.next();
        File outFile = new File(outFileName);
        PrintWriter outputWriter = new PrintWriter(outFile);
        outputWriter.printf("Results of the Portfolio %s over %d months\n", portfolioName, months);
        for(Investment investment : portfolioInvestments)
        {
            outputWriter.printf("%s\n", investment.toString());
            sum += investment.getInvestmentValue();
        }
        outputWriter.printf("The total value for all of the investments is $%.2f", sum);
        outputWriter.close();
    }
}