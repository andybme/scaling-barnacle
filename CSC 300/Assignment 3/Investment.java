/*
    Assignment #3 by Andy Me
*/
abstract class Investment
{
	private String type;
	private String name;
	private double investmentValue;
	public Investment()
	{
		setType("none");
		setName("none");
	}
	public Investment(String newType, String newName)
	{
		setType(newType);
		setName(newName);
	}
	public void setType(String newType){
		this.type = newType;
	}
	public String getType(){
		return this.type;
	}
		public void setName(String newName){
		this.name = newName;
	}
	public String getName(){
		return this.name;
	}
	public void setInvestmentValue(double newValue){
		this.investmentValue = newValue;
	}
	public double getInvestmentValue(){
		return this.investmentValue;
	}
	//toString and constructors
	public String toString(){
		String answer = String.format("Investment: %s Name: %s", this.type, this.name);
		return answer;
	}
}
