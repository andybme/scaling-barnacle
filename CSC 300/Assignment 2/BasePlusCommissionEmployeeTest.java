/*
    Assignment #2 by Andy Me
*/
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.PrintWriter;

public class BasePlusCommissionEmployeeTest
{
	public static void main(String[]args) throws FileNotFoundException
	{
		ArrayList<CommissionEmployee> cEmployee = new ArrayList<CommissionEmployee>();
		ArrayList<BasePlusCommissionEmployee> bEmployee = new ArrayList<BasePlusCommissionEmployee>();

		String commIn, baseIn, outfile;
		Scanner user = new Scanner(System.in);
		System.out.print("Commission Employee File Name: ");
		commIn = user.nextLine();
		System.out.print("Base Employee File Name: ");
		baseIn = user.nextLine();
		System.out.print("Output File Name: ");
		outfile = user.nextLine();

		double sum = 0, sum2 = 0;
		File commissionEmpInfo = new File (commIn);
		File baseEmpInfo = new File (baseIn);
		File output = new File (outfile);

		Scanner scanner = new Scanner(commissionEmpInfo);
		Scanner scanner2 = new Scanner(baseEmpInfo);
		PrintWriter writeOut = new PrintWriter(output);

		while (scanner.hasNextLine())
		{
			String fName, lName;
			double gross, percent;
			fName = scanner.next();
			lName = scanner.next();
			gross = scanner.nextDouble();
			percent = scanner.nextDouble();
			cEmployee.add(new CommissionEmployee(fName, lName, gross, percent));
		}
		while (scanner2.hasNextLine())
		{
			String fName, lName;
			double gross, percent, base;
			fName = scanner2.next();
			lName = scanner2.next();
			gross = scanner2.nextDouble();
			percent = scanner2.nextDouble();
			base = scanner2.nextDouble();
			bEmployee.add(new BasePlusCommissionEmployee(fName, lName, gross, percent, base));
		}

		writeOut.format("Statistics on Commission Only Employees\n");
		writeOut.format("FNAME     LNAME     Total Compensation\n");
		for (CommissionEmployee item: cEmployee)
		{
			writeOut.format("%s$%.2f\n", item.getName(), item.earnings());
			sum += item.earnings();
		}
		writeOut.format("Total Compensation For Commission Only Employees Is: $%.2f\n\n", sum);

		writeOut.format("Statistics On Base Pay Plus Commission Employees\n");
		writeOut.format("FNAME     LNAME     Total Compensation\n");
		for (BasePlusCommissionEmployee item: bEmployee)
		{
			writeOut.format("%s$%.2f\n", item.getName(), item.earnings());
			sum2 += item.earnings();
		}
		writeOut.format("Total Compensation For Base Plus Commission Employees Is: $%.2f\n\n", sum2);

		writeOut.format("Total Compensation For All Employees Is: $%.2f", (sum + sum2));

		writeOut.close();
	}
}