/*
    Assignment #5 by Andy Me
*/
import java.util.Comparator;

public class ComparatorMultiSort implements Comparator<Contractor>
{
	public int compare(Contractor a, Contractor b)
	{
		if(a.getName().compareTo(b.getName()) != 0) return a.getName().compareTo(b.getName());
		if(a.getLocation().compareTo(b.getLocation()) != 0) return a.getLocation().compareTo(b.getLocation());
		if((a.getOwnerID() - b.getOwnerID()) != 0) return (a.getOwnerID() - b.getOwnerID());
		return 0;
	}
}