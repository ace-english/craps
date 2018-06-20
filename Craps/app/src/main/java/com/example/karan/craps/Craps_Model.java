package com.example.karan.craps;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Craps_Model implements Craps_Interface{
	private double wallet; //contains user's money
	private int point;  //keeps track of the point value;
	Random rand;
	private boolean comeOutRoll;
	int[] dice;
	//contains dice roll (two)
	private Map<BetDestination, Integer> bets;
	//Bets array has an int corresponding to every possible value of betsDestination
	private Map<BetDestination, Double> odds;
	//	Stores the payout on any given bet
	
	public Craps_Model() {
        rand= new Random();
		dice = new int[2];
		wallet=500;
		bets=new TreeMap<>();

		odds=new TreeMap<>();
		//initalize odds
		for(BetDestination dest : BetDestination.values()){
			odds.put(dest, 1.0);
		}

		//buy bets give true odds, minus 5% of bet
		odds.put(BetDestination.buy4, 2.0);
		odds.put(BetDestination.buy5, (double)(3/2));
		odds.put(BetDestination.buy6, (double)(6/5));
		odds.put(BetDestination.buy8, (double)(6/5));
		odds.put(BetDestination.buy9, (double)(3/2));
		odds.put(BetDestination.buy10, 2.0);
		//lay bets give true odds against, minus 5% of bet
		odds.put(BetDestination.lay4, 0.5);
		odds.put(BetDestination.lay5, (double)(2/3));
		odds.put(BetDestination.lay6, (double)(5/6));
		odds.put(BetDestination.lay8, (double)(5/6));
		odds.put(BetDestination.lay9, (double)(2/3));
		odds.put(BetDestination.lay10, 0.5);
		//minicraps table
		odds.put(BetDestination.mini7, 5.0);
		odds.put(BetDestination.hard6, 10.0);
		odds.put(BetDestination.hard8,8.0);
		odds.put(BetDestination.hard10, 10.0);
		odds.put(BetDestination.hard4, 8.0);
		odds.put(BetDestination.mini3, 15.0);
		odds.put(BetDestination.mini2, 30.0);
		odds.put(BetDestination.mini12, 30.0);
		odds.put(BetDestination.mini11, 15.0);
		odds.put(BetDestination.mini_any, 8.0);



		newGame();
	}

	public double getWallet() {
		return wallet;
	}

	private void initializeDice() {
		dice[0]=rand.nextInt(6)+1;
		dice[1]=rand.nextInt(6)+1;
	}

	public boolean placeBet(BetDestination betDestination, int betValue)	//returns false if insufficient funds
	{
		if(comeOutRoll){
			switch (betDestination){	//these are bets you cannot place on the come out roll.
				case sideBet4:
				case sideBet5:
				case sideBet6:
				case sideBet8:
				case sideBet9:
				case sideBet10:
				case hard4:
				case hard6:
				case hard8:
				case hard10:
				case come:
				case dontCome:
					System.err.println("That is not allowed on the come out roll.");
					return false;
			}
		}
		if(wallet >= betValue){
			wallet-=betValue;
			if (bets.containsValue(betDestination))
				betValue+=bets.get(betDestination);//increments bet in that position
			bets.put(betDestination, betValue);
			return true;
		}
		else {
			System.err.println("Insufficient funds.");
			return false;
		}
	}

	public boolean newGame() // This will clear last game and create a new one.
	{
		point=0;
		comeOutRoll=true;
		return true;
	}
	public boolean loseGame()   // This will excutute a Lose game if the Dice rolls didnt go the players way.
	{
		bets.clear();
		return true;
	}

	public double payout(BetDestination betDestination){
		double multiplier;
		switch(betDestination) {
			case buy4:
			case buy5:
			case buy6:
			case buy8:
			case buy9:
			case buy10:
			case lay4:
			case lay5:
			case lay6:
			case lay8:
			case lay9:
			case lay10:
				//buy bets and lay bets have a 5% vigorish
				multiplier=0.95;
				break;
			default:
				multiplier=1;
		}
		return payout(betDestination, multiplier);
	}

	public double payout(BetDestination betDestination, double multiplier){
		double payout=0;
		if(bets.containsKey(betDestination)) {
			payout=bets.get(betDestination) + (bets.get(betDestination) * odds.get(betDestination) * multiplier);
			wallet += payout;
			System.out.println("$"+payout+" recieved from "+betDestination);
			bets.remove(betDestination);
		}
		return payout;
	}
	
	public double rollDice() {
		initializeDice();
		int diceValue=getDiceValue();
		double payoutValue=0;
		if(comeOutRoll) {
			switch(diceValue) {
				case 2:
				case 3:
				case 12:
					loseGame();
					break;
				case 7:
				case 11:
					payoutValue+=payout(BetDestination.passLine);
					break;
				default:
					point=diceValue;
					comeOutRoll=false;
			}

		}
		else {
			//payout
			switch(diceValue){
				case 2:
					payoutValue+=payout(BetDestination.mini2);
					payoutValue+=payout(BetDestination.mini_any);
					payoutValue+=payout(BetDestination.field, 2);
					break;
				case 3:
					payoutValue+=payout(BetDestination.mini_any);
					payoutValue+=payout(BetDestination.field);
					payoutValue+=payout(BetDestination.mini3);
					break;
				case 4:
					payoutValue+=payout(BetDestination.field);
					payoutValue+=payout(BetDestination.sideBet4);
					if(dice[0]==dice[1])
						payoutValue+=payout(BetDestination.hard4);
					break;
				case 5:
					break;
				case 6:
					payoutValue+=payout(BetDestination.big6);
					if(dice[0]==dice[1])
						payoutValue+=payout(BetDestination.hard6);
					break;
				case 7:
					payoutValue+=payout(BetDestination.lay4);
					payoutValue+=payout(BetDestination.lay5);
					payoutValue+=payout(BetDestination.lay6);
					payoutValue+=payout(BetDestination.lay8);
					payoutValue+=payout(BetDestination.lay9);
					payoutValue+=payout(BetDestination.lay10);
					payoutValue+=payout(BetDestination.mini7);
					break;
				case 8:
					payoutValue+=payout(BetDestination.big8);
					if(dice[0]==dice[1])
						payoutValue+=payout(BetDestination.hard8);
					break;
				case 9:
					payoutValue+=payout(BetDestination.field);
					break;
				case 10:
					payoutValue+=payout(BetDestination.field);
					if(dice[0]==dice[1])
						payoutValue+=payout(BetDestination.hard10);
					break;
				case 11:
					payoutValue+=payout(BetDestination.field);
					break;
				case 12:
					payoutValue+=payout(BetDestination.field, 3);
					payoutValue+=payout(BetDestination.mini_any);
					break;
			}

			//set point or lose
			switch (diceValue) {
				case 4:
				case 5:
				case 6:
				case 8:
				case 9:
				case 10:
					try {
						setPoint(diceValue);
					} catch (Exception e) {
						System.err.println(e.getMessage());
					}
					break;
				case 7:
					loseGame();
					break;
			}
		}
		//no matter what, clear the one-roll bets
		bets.remove(BetDestination.mini7);
		bets.remove(BetDestination.mini3);
		bets.remove(BetDestination.mini2);
		bets.remove(BetDestination.mini11);
		bets.remove(BetDestination.mini12);
		

		return payoutValue;
	}

	private boolean setPoint(int newPoint) throws Exception { //function validates the new point
	    switch(newPoint){
            case 4:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
                point=newPoint;
                return true;
            default:
                throw new Exception("Error: invalid point.");

        }
    }
	public int getPointValue() {
		return point;
	}
	
	public int getDie1() {
		return dice[0];
	}

	public int getDie2() {
		return dice[1];
	}

	public int getDiceValue(){
	    return dice[0]+dice[1];
    }

    public boolean isFirstTurn(){
	    return comeOutRoll;
    }

    public double getTotalBet(){
		double total=0;
		for(Map.Entry<BetDestination,Integer> bet : bets.entrySet())
			total+=bet.getValue();
		return total;
	}

    //test functions
	public void displayBets(){
		for(Map.Entry<BetDestination,Integer> bet : bets.entrySet())
			System.out.println(bet.getKey()+" : "+bet.getValue());
	}
}