package com.example.karan.craps;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Craps_Model implements Craps_Interface{
	private int wallet; //contains user's money
	private int point;  //keeps track of the point value;
	Random rand;
	private boolean comeOutRoll;
	int[] dice;
	//contains dice roll (two)
	private Map<BetDestination, Integer> bets;
	//Bets array has an int corresponding to every possible value of betsDestination
	
	public Craps_Model() {
        rand= new Random();
		dice = new int[2];
		wallet=500;
		bets=new TreeMap<>();
		newGame();
	}

	public int getWallet() {
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
		//TODO
		return false;
	}
	public boolean winGame()	// This will excutute a Win if the Dice rolls went the players way.
	{
		FieldBetPayout();
		return true;
	}
	public boolean FieldBetPayout()
	{
		wallet+=bets.get(BetDestination.passline);
		return true;
	}
	
	public int rollDice()
	{
		initializeDice();
		
		if(comeOutRoll) {
			switch(getDiceValue()) {
				case 2:
				case 3:
				case 12:
					loseGame();
					break;
				case 7:
				case 11:
					winGame();
					break;
				default:
					comeOutRoll=false;
			}

		}
		else {
			if(getPointValue()==7)
				loseGame();
			else {
			    try {
                    setPoint(getDiceValue());
                }
                catch (Exception e){
			        //oh well
                }
				winGame();
			}
		}
		return dice[0]+dice[1];
	}
	private boolean setPoint(int newPoint) throws Exception {
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
}