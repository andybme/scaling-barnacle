/*
    Assignment #3 by Andy Me
*/
public class VacationTest
{
	public static void main(String[]args)
	{
// part one
		System.out.println("The first all-inclusive vacation is:");
		AllInclusiveVacation aiv1 = new AllInclusiveVacation("Orlando", 1000.00, "Disney", 3, 989.49);
		System.out.printf("%s\n", aiv1.toString());
		if(aiv1.overBudget() == 0)
		{
			System.out.printf("It is exactly on budget\n\n");
		}else if(aiv1.overBudget() > 0)
		{
			System.out.printf("It is under budget by $%.2f\n\n", aiv1.overBudget());
		}else if(aiv1.overBudget() < 0)
		{
			System.out.printf("It is over budget by $%.2f\n\n", Math.abs(aiv1.overBudget()));
		}

// part two
		System.out.println("The second all-inclusive vacation is:");
		AllInclusiveVacation aiv2 = new AllInclusiveVacation("Bahamas", 2000.00, "ClubMed", 3, 2049.99);
		System.out.printf("%s\n", aiv2.toString());
		if(aiv2.overBudget() == 0)
		{
			System.out.printf("It is exactly on budget\n\n");
		}else if(aiv2.overBudget() > 0)
		{
			System.out.printf("It is under budget by $%.2f\n\n", aiv2.overBudget());
		}else if(aiv2.overBudget() < 0)
		{
			System.out.printf("It is over budget by $%.2f\n\n", Math.abs(aiv2.overBudget()));
		}

//part 1 and 2 comparison
		aiv2.setBrand(aiv1.getBrand());
		aiv2.setPrice(aiv1.getPrice());
		if(aiv1.equals(aiv2))
		{
			System.out.println("aiv1 and aiv2 are equal");
		}else if(!aiv1.equals(aiv2))
		{
			System.out.println("aiv1 and aiv2 are not equal");
		}
		aiv2.setDestination(aiv1.getDestination());
		aiv2.setBudget(aiv1.getBudget());
		if(aiv1.equals(aiv2))
		{
			System.out.println("aiv1 and aiv2 are now equal\n");
		}else if(!aiv1.equals(aiv2))
		{
			System.out.println("aiv1 and aiv2 are not equal\n");
		}

//piecemeal one
		String[] itemsList1 = new String[] {"hotel", "meals", "airfare", "windsurfing"};
		double[] costsList1 = new double[] {750.00, 250.00, 400};

		PieceMealVacation pmv1 = new PieceMealVacation("Miami", 1500.00, itemsList1, costsList1);
		System.out.println("The first piecemeal vacation is:");
		System.out.printf("%s\n", pmv1.toString());
		if(pmv1.overBudget() == 0)
		{
			System.out.printf("It is exactly on budget\n\n");
		}else if(pmv1.overBudget() > 0)
		{
			System.out.printf("It is under budget by $%.2f\n\n", pmv1.overBudget());
		}else if(pmv1.overBudget() < 0)
		{
			System.out.printf("It is over budget by $%.2f\n\n", Math.abs(pmv1.overBudget()));
		}

//piecemeal two
		String[] itemsList2 = new String[] {"hotel", "meals", "airfare", "windsurfing"};
		double[] costsList2 = new double[] {750.00, 250.00, 400.00, 120.00, 200.00};

		PieceMealVacation pmv2 = new PieceMealVacation("Miami", 1500.00, itemsList2, costsList2);
		System.out.println("The first piecemeal vacation is:");
		System.out.printf("%s\n", pmv2.toString());
		if(pmv2.overBudget() == 0)
		{
			System.out.printf("It is exactly on budget\n\n");
		}else if(pmv2.overBudget() > 0)
		{
			System.out.printf("It is under budget by $%.2f\n\n", pmv2.overBudget());
		}else if(pmv2.overBudget() < 0)
		{
			System.out.printf("It is over budget by $%.2f\n\n", Math.abs(pmv2.overBudget()));
		}

//piecemeal comparisons
		pmv2.setItems(itemsList1);
		if(pmv1.equals(pmv2))
		{
			System.out.println("pmv1 and pmv2 are now equal");
		}else if(!pmv1.equals(pmv2))
		{
			System.out.println("pmv1 and pmv2 are not equal");
		}
// note to professor: I think there's a typo. In the doc it says "Set pmv2 costs to costsList2"
// it was already equal to costsLists 2 in the constructor and instructions
		pmv2.setCosts(costsList1);
		if(pmv1.equals(pmv2))
		{
			System.out.println("pmv1 and pmv2 are now equal\n");
		}else if(!pmv1.equals(pmv2))
		{
			System.out.println("pmv1 and pmv2 are not equal\n");
		}
	}
}