/*
    Assignment #6 by Andy Me
*/
import java.util.ArrayList;

public class WildCardTester
{
	public static void addCat(ArrayList<? super RedCat> list, String name)
	{
		list.add(new RedCat(name));
		System.out.printf("Cat Added named %s was added\n", name);
	}

	public static <T> void printAll(ArrayList<T> list)
	{
		for (T element : list) 
		{ 
			System.out.printf("%s ", element);
		}
		System.out.println();
	}

	public  static void deleteCat(ArrayList<? extends Cat> list, String name)
	{
		for (Cat element : list) 
		{
			if (element.name == name) list.remove(element);
			System.out.printf("Removed cat named %s\n", name);
			return;
		}
	}

	public static void main(String[] args)
	{
		ArrayList<Animal> animalList = new ArrayList<>();
		ArrayList<RedCat> redCatList = new ArrayList<>();
		addCat(animalList, "Tiger");
		addCat(redCatList, "Tom");
		addCat(redCatList, "Siamese");
		addCat(redCatList, "Tiger");
		System.out.println("The list of animals:");
		printAll(animalList);
		System.out.println("The list of redCats:");
		printAll(redCatList);
		deleteCat(redCatList, "Tom");
		System.out.println("The list of redCats after a deletion:");
		printAll(redCatList);
	}
}