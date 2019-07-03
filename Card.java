package danielsPackage;
public class Card {
	
	private String CardName;
	private int power;
	private int transferPower;
	private int income;
	private int resistance;
	//real card constructor
	public Card(String name, String powerVal, String transferPowerVal, String incomeVal, String resistanceVal) {
		CardName= name;
		power=Integer.parseInt(powerVal);
		transferPower=Integer.parseInt(transferPowerVal);
		income=Integer.parseInt(incomeVal);
		resistance=Integer.parseInt(resistanceVal);
	}
	//dummy card constructor for java restrictoins
	public Card()
	{
		
	}
	 // return cardname
	public String getCardName() {
		return CardName;
	}
	//return power val
	public int getPowerVal() {
		return power;
	}
	// return income val
	public int getIncomeVal() {
		return income;
	}
	//return resistance val
	public int getResistanceVal() {
		return resistance;
	}
	//return transferable power val
	public int getTransferPowerVal() {
		return transferPower;
	}
	//returns a string with all attributes
	public String toString() {
		return "Card Name: "+CardName+" Power: "+power+" Transfer Power: "+transferPower+" Income: "+income+" Resistance: "+resistance;
	}
	
	
}
