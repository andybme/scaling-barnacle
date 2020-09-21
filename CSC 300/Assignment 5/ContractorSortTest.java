/*
    Assignment #5 by Andy Me
*/
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.io.File;

public class ContractorSortTest
{
	public static void main(String[]args) throws IOException
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter the name of the input file with Contractor Data:");
        String inputFileName = keyboard.nextLine();
        File inputFile = new File(inputFileName);
        ArrayList<Contractor> contractors = buildList(inputFile);


// name portion
        Collections.sort(contractors, new ComparatorSortName()); 
        System.out.println("\nList Sorted By Contractor Name");
        printList(contractors);

// location portion
        Collections.sort(contractors, new ComparatorSortLocation()); 
        System.out.println("\nList Sorted by Location");
        printList(contractors);

// ownerID portion
        Collections.sort(contractors, new ComparatorSortOwnerID()); 
        System.out.println("\nList Sorted By OwnerID");
        printList(contractors);

//multisort portion
        Collections.sort(contractors, new ComparatorMultiSort()); 
        System.out.println("\nList Sorted By Contractor Name");
        printList(contractors);
	}
	
	public static ArrayList<Contractor> buildList(File inputFile) throws IOException
    {
        Scanner input = new Scanner(inputFile);
    	ArrayList<Contractor> contractors = new ArrayList<Contractor>();
        String name;
        String location;
        int ownerID;
        while(input.hasNextLine())
        {
        	name = input.next();
        	location = input.next();
        	ownerID = input.nextInt();
        	contractors.add(new Contractor(name, location, ownerID));
        }
        input.close();
        return contractors;
    }

    public static void printList(ArrayList<Contractor> contractors)
    {
    	for(Contractor item : contractors)
    	{
    		System.out.printf("%s\n", item);
    	}
    }
}