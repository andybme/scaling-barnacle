/*
    Assignment #6 by Andy Me
*/
import java.util.ArrayList;

public class HasNullsTest
{
	public static <T> boolean HasNulls(ArrayList<T> inputArray) 
	{ 
		// display array elements 	
		for (T element : inputArray)
		{ 
			if(element == null) return true;
		} 		
		return false;	
	}
	public static void main(String[] args)
	{
		ArrayList list1 = new ArrayList<Integer>();
		Integer inty = 3;
		list1.add(inty);
		inty = 4;
		list1.add(inty);
		inty = 5;
		list1.add(inty);

		ArrayList list2 = new ArrayList<Integer>();
		list2.add(inty);
		inty = null;
		list2.add(inty);
		inty = 32300;
		list2.add(inty);

		System.out.println(HasNulls(list1));
		System.out.println(HasNulls(list2));
	}
}