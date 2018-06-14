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


				//passline,
		//	sidebet4, sidebet5, sidebet6, sidebet8, sidebet9, sidebet10,
		//	big6, big8,
		//	field, dontpassbar,
		//	mini7, hard6, hard10, hard8, hard4, mini2, mini3, mini12, mini11, mini_any;
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
		if(wallet >= betValue)
		{
			wallet-=betValue;
			bets.put(betDestination, bets.get(betDestination)+betValue); //increments bet in that position
			return true;
		}
		return false;
	}

	public boolean newGame() // This will clear last game and create a new one.
	{
		point=0;
		comeOutRoll=true;
		//TODO: initialize text fields in interface
		return true;
	}
	public boolean loseGame()   // This will excutute a Lose game if the Dice rolls didnt go the players way.
	{
		bets.clear();
		return true;
	}

	public boolean payout(BetDestination betDestination){
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

	public boolean payout(BetDestination betDestination, double multiplier){
		wallet+=bets.get(betDestination)+(bets.get(betDestination)*odds.get(betDestination)*multiplier);
		bets.put(betDestination, 0);
		return true;
	}
	
	public int rollDice() {
		initializeDice();
		int diceValue=getDiceValue();
		if(comeOutRoll) {
			switch(diceValue) {
				case 2:
				case 3:
				case 12:
					loseGame();
					break;
				case 7:
				case 11:
					payout(BetDestination.passline);
					break;
				default:
					comeOutRoll=false;
			}

		}
		else {
			//payout
			switch(diceValue){
				case 2:
					payout(BetDestination.mini2);
					payout(BetDestination.mini_any);
					break;
				case 3:
					payout(BetDestination.mini_any);
					payout(BetDestination.field, 2);
					payout(BetDestination.mini3);
					break;
				case 4:
					payout(BetDestination.field);
					payout(BetDestination.sidebet4);
					break;
				case 5:
					break;
				case 6:
					wallet+=bets.get(BetDestination.big6);
					break;
				case 7:
					payout(BetDestination.mini7);
					break;
				case 8:
					break;
				case 9:
					break;
				case 10:
					break;
				case 11:
					break;
				case 12:
					payout(BetDestination.mini_any);
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
		bets.put(BetDestination.mini7, 0);
		bets.put(BetDestination.mini3, 0);
		bets.put(BetDestination.mini2, 0);
		bets.put(BetDestination.mini11, 0);
		bets.put(BetDestination.mini12, 0);

		return dice[0]+dice[1];
	}

	private boolean setPoint(int newPoint) throws Exception { //function validates the new point
	    switch(newPoint){
            case 4:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:{
                point=newPoint;
            }
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

    //test functions
	public void displayBets(){
		for(Map.Entry<BetDestination,Integer> bet : bets.entrySet())
			System.out.println(bet.getKey()+" : "+bet.getValue());
	}
}