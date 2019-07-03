package danielsPackage;
import java.util.ArrayList;
public class Player implements Comparable<Player> {
	
	private String name;
	private ArrayList<Card>groups;
	private ArrayList<Card>specials;
	private Card Illuminati;
	private int money;
	private int transferablePower;
	private int totalPower;
	private int alignmentCount;
	private int weirdCount;
	private int violentCount;
	private int groupsDestroyed;
	private int actions;
	private int priority;
	
/**
 * 
 * is the basic constructor of the player object
 * @param name
 */
	public Player (String name) {
		this.name = name;
	}
	
	
	
	//add Illuminati Card to a player
	public void addIlluminati(Card Illuminati)
	{
		this.Illuminati = Illuminati;
	}
	 //+1 to groups destroyed
	public void addDestroyCount()
	{
		groupsDestroyed++;
	}
	//get amoutn of groups destroyed
	public int getDestroyedCount()
	{
		return groupsDestroyed;
	}
	//set num of actoins
	public void setActions(int count)
	{
		actions = count;
	}
	//get num of actoins
	public int getActions()
	{
		return actions; 
	}
	//set int of violentCount
	public void setViolentCount(int count)
	{
		violentCount = count;
	}
	//return int of violent count
	public int getViolentCount()
	{
		return violentCount;
	}
	//set int of weird cards
	public void setWeirdCount(int count)
	{
		weirdCount = count;
	}
	//get int of weird cards
	public int getWeirdCount()
	{
		return weirdCount;
	}
	//get int of transferable power
	public int getTransferablePower()
	{
		return transferablePower;
	}
	//set int of transferable power
	public void setTransferablePower(int count)
	{
		transferablePower = count;
	}
	//set alignment count
	public void setAlignmentCount(int count)
	{
		alignmentCount = count;
	}
	//get alignment ocunt
	public int getAlignmentCount()
	{
		return alignmentCount;
	}
	//return player's illuminati card
	public Card getIlluminatiCard()
	{
		return Illuminati;
	}
	//get players power
	public int getTotalPower()
	{
		return totalPower;
	}
	//set players power
	public void setTotalPower(int pow)
	{
		totalPower = pow;
	}
	//set players money
	public void setTotalMoney(int money)
	{
		this.money = money;
	}
	//get players money
	public int getTotalMoney()
	{
		return money;
	}
	
	public int getPriority()
	{
		return priority;
	}
	
	public void setPriority(int priority)
	{
		this.priority = priority;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int compareTo(Player p2)
	{
		return (this.getPriority() < p2.getPriority() ? -1 : 
			(this.getPriority() == p2.getPriority() ? 0 : 1));
	}
	
	
	
	
	
	
	
	//return list of strings of player group names
	public ArrayList<String> getGroups()
	{
		ArrayList<String> groupNames = new ArrayList<String>();
		for(int i = 0; i < groups.size(); i++)
		{
			groupNames.add(groups.get(i).getCardName());
		}
		
		return groupNames;
	}
	//return list of strings of plaeyrs special card names
	public ArrayList<String> getSpecials()
	{
		ArrayList<String> specNames = new ArrayList<String>();
		for(int i = 0; i < specials.size(); i++)
		{
			specNames.add(specials.get(i).getCardName());
		}
		
		return specNames;
	}
	
	//removes special card
	public Card removeSpecial(String name)
	{
		Card c = new Card();
		for(int i = 0; i < specials.size(); i++)
		{
			if(specials.get(i).getCardName().equals(name))
			{
				c = specials.remove(i);
				
			}
		}
		return c;
	}
	
	//adds special card 
	public void addSpecial(Card special)
	{
		specials.add(special);
	}
	
	public Card removeGroup(String name)
	{
		Card c = new Card();
		for(int i = 0; i < groups.size();i++)
		{
			if(groups.get(i).getCardName().equals(name))
			{
				c= groups.remove(i);
			}
		}
		return c;
	}
	
	public void addGroup(Card group)
	{
		groups.add(group);
	}

}
