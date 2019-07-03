package danielsPackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class mainFile{ 	
	
	public static ArrayList<Player> playerList;
	public static LinkedList cards;
	
	public static void main(String[] args) {
		
		
		Scanner in = new Scanner(System.in);
		LinkedList cards1 = new LinkedList();
		ArrayList<String>playersName = new ArrayList<>();
		menu();
		String next = in.next();
		System.out.println("Enter the number of players (2-8): ");
		int number = getIntRange(2,8);
		
		playersName =players(number);
		playerList = playerCreator(playersName);
		
		
		//sets priority of players for turn control
		for(int i = 0; i < playerList.size(); i++) {
			playerList.get(i).setPriority(rolldice(playerList.get(i).getName()));
			//System.out.println(playerList.get(i).getPriority());
		}
		
		Collections.sort(playerList);
		
		readfile(cards1);
		cards = cards1;
		
		shuffleDeck(cards);
		
		gameLoop();
		
		//System.out.println(playerList.size());
	}
	
	//first menu
	public static void menu() {
		System.out.println("Welcome to the illuminati game!\n"
							+"Press a character to continue.");
	}
	
	//restricts playres from choosing any number below 2 or above 8
	public static int getIntRange( int low, int high ) {
		Scanner in = new Scanner( System.in );
		int input = 0;
		boolean valid = false;
		while( !valid ) {
			if( in.hasNextInt() ) {
				input = in.nextInt();
				if( input <= high && input >= low ) {
					valid = true;
				} else {
					System.out.println( "Invalid Range." );
				}
			} else {
				in.next(); //clear invalid string
				System.out.println( "Invalid Input." );
			}
		}
		return input;
	}
	//reads in all cards from a text file to scan all details about them in
	public static void readfile(LinkedList card) {
		String [] [] details = new String[][] {
			{"American Autoduel Association","1","0","5","1"},
			{"Anti-Nuclear Activists","2","0","5","1"},
			{"Antiwar Activists","0","0","3","1"},
			{"Big Media","4","3","6","3"},
			{"Boy Sprouts","0","0","3","1"},
			{"California","5","0","4","5"},
			{"CFL-AIO","6","0","5","3"},
			{"Chinese Campaign Donors","3","0","2","3"},
			{"CIA","6","4","5","0"},
			{"Clone Arrangers","6","2","6","1"},
			{"Comic Books","1","0","1","2"},
			{"Congressional Wives","1","0","4","1"},
			{"Convenience Stores","1","0","4","3"},
			{"Copy Shops","1","0","3","4"},
			{"Cycle Gangs","0","0","4","0"},
			{"Democrats","5","0","4","3"},
			{"Eco-Guerrillas","0","0","6","1"},
			{"Empty Eve","3","0","3","4"},
			{"Evil Geniuses for a better tomorrow","0","2","6","3"},
			{"Fast food chains","2","0","4","3"},
			{"FBI","4","2","6","0"},
			{"Federal Reserve","5","3","7","6"},
			{"Feminists","2","0","2","1"},
			{"Fiendish Fluoridators","3","0","5","1"},
			{"Flat earthers","1","0","2","1"},
			{"Ford Motor Company","2","0","4","2"},
			{"Fraternal Orders 3","0","5","2"},
			{"Girlie Magazines"," 2","0","2","3"},
			{"Goldfish Fanciers","0","0","4","1"},
			{"Gun lobby","1","0","3","1"},
			{"Hackers","1","1","2","3"},
			{"Health food stores","1","0","3","2"},
			{"Hollywood","2","0","0","5"},
			{"Intellectuals","0","0","3","1"},
			{"International Cocaine Smugglers","3","0","5","5"},
			{"International Communist Conspiracy","7","0","8","6"},
			{"IRS","5","3","5","2"},
			{"Junk Mail","1","0","3","2"},
			{"KGB","2","2","6","0"},
			{"KKK","2","0","5","1"},
			{"L-4 Society","1","0","2","0"},
			{"Libertarians","1","0","4","1"},
			{"Loan Sharks","5","0","5","6"},
			{"Local Police Departments","0","0","4","1"},
			{"Madison Avenue","3","3","3","2"},
			{"The Mafia","7","0","7","6"},
			{"The men in black","0","2","6","1"},
			{"Militia","2","0","4","2"},
			{"Moonies","2","0","4","3"},
			{"Moral Minority","2","0","1","2"},
			{"Morticians","0","0","4","1"},
			{"Multinational Oil Companies","6","0","4","8"},
			{"Nephews of God","0","0","4","2"},
			{"New York","7","0","8","3"},
			{"Nuclear Power Companies","4","0","4","3"},
			{"Orbital Mind Control Lasers","4","2","5","0"},
			{"Parent/Teacher Agglomeration","0","0","5","1"},
			{"Pentagon","6","0","6","2"},
			{"The phone company","5","2","6","3"},
			{"Phone Phreaks","0","1","1","1"},
			{"Post Office","4","3","3","1"},
			{"Professional sports","2","0","4","3"},
			{"Psychiatrists","0","0","6","2"},
			{"Punk Rockers","0","0","4","1"},
			{"Recyclers","2","0","2","3"},
			{"Republicans","4","0","4","4"},
			{"Robot Sea monsters","0","0","6","2"},
			{"Science Fiction","0","0","5","1"},
			{"Semiconscious liberation army","0","0","8","0"},
			{"SMOF","1","0","1","0"},
			{"Society for creative anarchism","0","0","4","1"},
			{"South American nazis","4","0","6","2"},
			{"Survivalists","0","0","6","2"},
			{"Tabloids","2","0","3","3"},
			{"Texas","6","0","6","4"},
			{"Tobacco and liquor companies","4","0","3","3"},
			{"Trekkies0","0","4","3"},
			{"Trilateral commission","5","0","6","3"},
			{"TV Preachers","3","0","6","4"},
			{"Underground newspapers","1","1","5","0"},
			{"The United Nations","1","0","3","3"},
			{"Video games","2","0","3","7"},
			{"Yuppies","1","1","4","5"}
		};
		
		for(int i = 0; i < details[0].length; i++) {
			card.add(new Card(details[i][0] ,details[i][1], details[i][2], details[i][3] ,details[i][4] ));
		}
		
	}
		
		
		
		
		
		
	

	
	//generates a dice roll from 2 - 12
	public static int rolldice(String player) {
		//playerList = playerCreator(players);
		Scanner in = new Scanner(System.in);
		System.out.println("\nLet's roll dice to decide who is first\n");
		
		//for (int j=0; j<players.size(); j++) {
			int die1 = (int)(6*Math.random()+1);
			int die2 = (int)(6*Math.random()+1);
			int total=die1+die2;
			
			char c;
			System.out.println(player + ", it's your turn. Roll the dice by pressing 'R' or 'r'.");
			c=in.next().toUpperCase().charAt(0);
			
			while(c!='R') 
			{
				System.out.println("\nSorry!!! You Didn't Press correct letter");
				System.out.print("Roll the dice by pressing 'R' or 'r'.\n");
				c=in.next().toUpperCase().charAt(0);
			}
			//c=in.next().toUpperCase().charAt(0);
			
			System.out.println("\n" +player);
			System.out.println("Die 1: "+ die1);
			System.out.println("Die 2: "+ die2);
			System.out.println("Your Total is: "+total+"\n");
		//}
			return total;
	}

	//creates an arraylist of player names to use to generate player objects
	public static ArrayList<String> players(int number){
		ArrayList<String>members=new ArrayList<>();
		Scanner in = new Scanner(System.in);
		String name;
		for(int i=0;i<number;i++) {
			System.out.println("\nEnter player "+(i+1)+"'s name: ");
			name=in.next();
			members.add(name);
		}
		//System.out.println(members.size());
		return members;
	}
	
	
	//creates an arrayList of player objects
	public static ArrayList<Player> playerCreator(ArrayList<String> players)
	{
		//System.out.println(players.size());
		ArrayList<Player>playerList = new ArrayList<>();
		String temp = "";
		for(String s: players)
		{
			//System.out.println(s);
			playerList.add(new Player(s));
			
		}
		return playerList;
		
	}
	
	
	public static LinkedList shuffleDeck(LinkedList deck) {
	    for(int i=0; i<deck.size(); i++) {
	        int card = (int) (Math.random() * (deck.size()-i));
	        deck.add(deck.remove(card));
	    }
	    return deck;
	}
	
	
	
	
	
	public static void gameLoop()
	{
		
		boolean continueGame = true;
		Iterator<Player> iter;
		Player p = playerList.get(0);
		Scanner input = new Scanner(System.in);
		while(continueGame)
		{
			iter = playerList.iterator();
			while(iter.hasNext()) {
				p = iter.next();
				System.out.println(p.getName() + ": What would you like to do?");
				System.out.println("Press 1 for trade, 2 for attack, 3 for move group, 4 for money transfer, 5 for pass." );
				boolean looper = true;
				int decision = -1;
				while(looper)
				{
					try {
						decision = input.nextInt();
						if(decision < 0 || decision > 5)
							throw new InputMismatchException();
						looper = false;
					}catch(InputMismatchException ex)
					{
						System.out.println("Please insert a valid response");
					}
				}
				if(decision == 1) {
					System.out.println("Who would you like to trade with?");
					String temp = "";
					int trader = -1;
					
					for(int i = 0; i < playerList.size(); i++) {
						System.out.println(playerList.get(i).getName());
					}
					
					looper = true;
					while(looper)
					{
						try {
							temp = input.nextLine();
							if(temp.equals(p.getName()))
								throw new InputMismatchException();
							for(int i = 0; i < playerList.size(); i++)
								{
									if(temp.equals(playerList.get(i).getName()))
									{
										trader = i;
										looper = false;
									}
								}
							}catch(InputMismatchException ex)
						{
							System.out.println("Please insert a valid response.");
						}
					}
					
					trade(p, playerList.get(trader));
					
				}
				else if(decision == 5) {
					
				}
			
			
			
			}
			
			
			if(SpecialGoals.checkGoals(p))
				continueGame = false;
				
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
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
		
		
		input.close();
	}


}

