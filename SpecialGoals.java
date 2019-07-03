package danielsPackage;

public class SpecialGoals {

	//this function runs through a big if statement trying to determine if a player has achieved their specific special goal
	public static boolean checkGoals(Player p1)
	{
		String cardType = p1.getIlluminatiCard().getCardName();
		if(cardType == "The Bavarian Illuminati")
		{
			if(p1.getTotalPower() >= 35)  // get power of power structure
				return true;
		}
		else if(cardType == "The Bermuda Triangle")
		{
			if(p1.getAlignmentCount() >= 10)  // alignmentCount is number of dif alignments within the power structure
				return true;
		}
		else if(cardType == "The Discordian Society")
		{
			if(p1.getWeirdCount() >= 5) //weirdCount is number of different cards with weird alignment
				return true;
		}
		else if(cardType == "The Gnomes of Zurich")
		{
			if(p1.getTotalMoney() >= 150) //total amount of MB
				return true;
		}
		else if(cardType == "The Network") 
		{
			if(p1.getTransferablePower() >= 25) //total amount of transferable power
				return true;
		}
		else if(cardType == "The Servants of Cthulu")
		{
			if(p1.getDestroyedCount() >= 5) //amount of groups destroyed 
				return true;
		}
		else if(cardType == "The Society of Assassins")
		{
			if(p1.getViolentCount() >=6) //amount of violent groups controlled
				return true;
		}
		return false;
	}
	
}
