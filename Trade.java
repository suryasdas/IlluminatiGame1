package danielsPackage;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Trade {
	
	/**
	 * 
	 * getGroups should return a list of strings of player's groups' names
	 * getSpecials should return a list of strings of player's specials' names
	 * @param p1
	 * @param p2
	 */
	
	public static void trade(Player p1, Player p2)
	{
		Scanner input = new Scanner(System.in);
		int groupNum = 0; //num of groups traded away
		int count = -1; //num of groups selected
		boolean loopBreaker = true; //loop control
		
		/**
		 * 
		 * begin trade with what player plans to give
		 * 
		 */
		
		System.out.println("How many groups would you like to trade away?");
		//loops to get number of groups to trade
		while(loopBreaker)
		{
			try {
				groupNum = input.nextInt();
				if(groupNum < 0 || groupNum > 2)
					throw new InputMismatchException();
				loopBreaker = false;
			}catch(InputMismatchException ex)
			{
				System.out.println("Please input a valid number.");
			}
		}
		
		
		ArrayList<String> groups = p1.getGroups();
		ArrayList<String> traders = new ArrayList<>(); 
		//groups to trade away 
		if(groupNum > 0) {
			System.out.println("What group(s) would you like to trade away?");
			
			
			
			String groupToTrade = "";
			
			for(int i = 0; i < groups.size(); i++)
			{
				System.out.println(groups.get(i));
			}
			
			//loops until given a valid choice
			loopBreaker = true;
			while(loopBreaker)
			{
				groupToTrade = input.nextLine();
				for(int i = 0; i < groups.size(); i++)
				{
					if(groupToTrade.equals(groups.get(i)))
					{
						traders.add(groupToTrade);
						count++;
					}
				}
				if(count==groupNum)
					loopBreaker=false;
			}
		}
		
		System.out.println("Would you like to give out any money or special cards?\n"
				+ "If so, press 1 for money, 2 for cards, or 3 for both. 0 would be neither.");
		
		
		loopBreaker = true;  //reset looper
		count = -1; //reset counter, reuse for control
		int money = -1;
		
		//loop to process what player would like to give
		while(loopBreaker)
		{
			try {
				count = input.nextInt();
				if( count < 0 || count > 3)
					throw new InputMismatchException();
				loopBreaker = false;
				
			}catch(InputMismatchException ex)
			{
				System.out.println("Please insert a valid response.");
			}
		}
		
		loopBreaker = true;
		//reset looper
		
		//how much money to trade
		if(count ==1 || count ==3 )
		{
			System.out.println("How much money would you like to give?");
			while(loopBreaker)
			{
				try {
					money = input.nextInt();
					if(money < 0 || money > p1.getTotalMoney())
						throw new InputMismatchException();
					loopBreaker = false;
				}catch(InputMismatchException ex)
				{
					System.out.println("Please insert a valid response.");
				}
			}
			
			loopBreaker = true;
		}
		ArrayList<String> p1Special = p1.getSpecials();
		ArrayList<String> p1SpecToTrade = new ArrayList<>();
		String special = "";
		// which specials to trade
		if( count ==2 || count == 3 )
		{
			System.out.println("Which specials would you like to trade?");
			for(int i = 0; i < p1Special.size(); i++)
				System.out.println(p1Special.get(i));
			while (loopBreaker)
			{
				special = input.nextLine();
				for(int i = 0; i < p1Special.size(); i++) {
					if(special.equals(p1Special.get(i)))
						p1SpecToTrade.add(special);
				}
				
				System.out.println("Would you like to add another?\nType 0 for no and 1 for yes.");
				boolean temp = true;
				int tempo = -1; //temp for deciding 
				while(temp)
				{
					try {
						tempo = input.nextInt();
						if(tempo != 0 && tempo !=1)
							throw new InputMismatchException();
						temp = false;
					}catch(InputMismatchException ex)
					{
						System.out.println("Please insert a valid response");
					}
				}
				
				if(tempo == 0)
					loopBreaker = false;
			}
			//reset looper
			loopBreaker = true;
		}
		
		/**
		 * 
		 * money, traders, and p1SpecToTrade are given to other player
		 * 
		 * moneyEarned, groupsToGet, and p2SpecToTrade are taken from other player
		 * 
		 * 
		 * 
		 * 
		 */
		
		
		
		/**
		 * 
		 * end trade with what player wishes to receive
		 * 
		 */
		
		
		System.out.println("What would you like in return?\n"
				+ "Put 0 for nothing, 1 for money, 2 for groups, or 3 for special cards,\n4 for groups and money,"
				+ " 5 for groups and special cards, 6 for money and special, and 7 for all.");
		int count2 = -1; //count for receiving
		int moneyEarned = -1;
		while(loopBreaker)
		{
			try {
				count2 = input.nextInt();
				if(count2 < 0 || count2 > 8)
					throw new InputMismatchException();
				loopBreaker = false;
			}
			catch(InputMismatchException ex)
			{
				System.out.println("Please insert a valid response.");
			}
		}
		
		//loop for receiving an amount of money
		
		loopBreaker = true; //reset looper
		if(count2 ==1 || count2==4 || count2 == 6 || count2 == 7)
		{
			System.out.println("How much money would you like to receive?");
			
			while(loopBreaker) {
				try {
					moneyEarned = input.nextInt();
					if(moneyEarned < 0)
						throw new InputMismatchException();
					loopBreaker = false;
				}
				catch(InputMismatchException ex)
				{
					System.out.println("Please insert a valid response.");
				}
			}
			
		}
		
		loopBreaker = true; //reset looper
		//loop for receiving groups
		
		ArrayList<String> p2Group = p2.getGroups();
		ArrayList<String> groupsToGet = new ArrayList<>();
		
		int groupReceived = -1; //groups you wish to receive
		int temporary = -1; // temp variable to compare to groups asked for
		if(count2 ==2 || count2 == 4 ||count2 == 5 || count2 ==7)
		{
			System.out.println("How many groups would you like to receive?");
			while(loopBreaker)
			{
				try {
					groupReceived = input.nextInt();
					if(groupReceived < 0 || groupReceived > 2)
						throw new InputMismatchException();
					loopBreaker = false;
				}catch(InputMismatchException ex)
				{
					System.out.println("Please insert a valid answer.");
				}
			}
			
			
			if(groupReceived > 0) 
			{
				System.out.println("What group(s) would you like to receive?");
				String groupToGet = "";
				for(int i = 0; i < p2Group.size();i++)
				{
					System.out.println(p2Group.get(i));
				}
				
				loopBreaker = true; //looper reset
				while(loopBreaker)
				{
					groupToGet = input.nextLine();
					for(int i = 0; i < groups.size(); i++)
					{
						if(groupToGet.equals(groups.get(i)))
						{
							groupsToGet.add(groupToGet);
							temporary++;
						}
					}
					if(temporary==groupReceived)
						loopBreaker=false;
				}
			}
		}
		
		
		//trading for special cards to receive
		ArrayList<String> p2Special = p2.getSpecials();
		ArrayList<String> p2SpecToTrade = new ArrayList<>();
		special = "";
		if(count2 == 3 || count2 == 5 || count2 ==6 ||count2 == 7)
		{
			System.out.println("What special cards would you like to receive?");
			for(int i = 0; i < p2Special.size(); i++)
			{
				System.out.println(p2Special.get(i));
			}
			loopBreaker = true; //loooper reset
			while (loopBreaker)
			{
				special = input.nextLine();
				for(int i = 0; i < p2Special.size(); i++) {
					if(special.equals(p2Special.get(i)))
						p2SpecToTrade.add(special);
				}
				
				System.out.println("Would you like to add another?\nType 0 for no and 1 for yes.");
				boolean temp = true;
				int tempo = -1; //temp for deciding 
				while(temp)
				{
					try {
						tempo = input.nextInt();
						if(tempo != 0 && tempo !=1)
							throw new InputMismatchException();
						temp = false;
					}catch(InputMismatchException ex)
					{
						System.out.println("Please insert a valid response");
					}
				}
				
				if(tempo == 0)
					loopBreaker = false;
			}
			
			
		}
		
		
		/**
		 * 
		 * money, traders, and p1SpecToTrade are given to other player
		 * 
		 * moneyEarned, groupsToGet, and p2SpecToTrade are taken from other player
		 * 
		 * 
		 * 
		 * 
		 */
		if(traders.size() + groupsToGet.size() <= p1.getActions())
		{
			if(money != -1)
			{
				p1.setTotalMoney(p1.getTotalMoney() - money);
				p2.setTotalMoney(p2.getTotalMoney() + money);
			}
			if(moneyEarned != -1)
			{
				p1.setTotalMoney(p1.getTotalMoney() + moneyEarned);
				p2.setTotalMoney(p2.getTotalMoney() - moneyEarned);
			}
			
			for(int i = 0; i < traders.size(); i++)
			{				
				p2.addGroup(p1.removeGroup(traders.get(i)));
			}
			
			for(int i = 0; i < groupsToGet.size(); i++)
			{
				p1.addGroup(p2.removeGroup(groupsToGet.get(i)));
			}
			for(int i = 0; i < p1SpecToTrade.size(); i++)
			{				
				p2.addSpecial(p1.removeSpecial(p1SpecToTrade.get(i)));
			}
			
			for(int i = 0; i < p2SpecToTrade.size(); i++)
			{
				p1.addSpecial(p2.removeSpecial(p2SpecToTrade.get(i)));				
			}
			
			p1.setActions(p1.getActions() - (traders.size() + groupsToGet.size()));
		}
		else
		{
			System.out.println("Not enough actions remaining.");
		}
		
		
	}

}
