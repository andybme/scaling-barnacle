/*
    Assignment #5 by Andy Me
*/

public class Contractor
{
	private String name = "";
	private String location = "";
	private int ownerID;

	public Contractor()
	{

	}
	public Contractor(String n, String l, int o)
	{
		setName(n);
		setLocation(l);
		setOwnerID(o);
	}

	public void setName(String n)
	{
		this.name = n;
	}
	public void setLocation(String l)
	{
		this.location = l;
	}
	public void setOwnerID(int i)
	{
		this.ownerID = i;
	}

	public String getName()
	{
		return this.name;
	}
	public String getLocation()
	{
		return this.location;
	}
	public int getOwnerID()
	{
		return this.ownerID;
	}

	public String toString()
	{
		return String.format("%s %s %d", name, location, ownerID);
	}
}