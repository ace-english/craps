package com.example.karan.craps;

import android.app.Activity;
import android.content.Context;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Craps_Model implements Craps_Interface{
	private double wallet; //contains user's money
	private int point;  //keeps track of the point value;
	Random rand;
	private boolean comeOutRoll;
	int[] dice;
	private Map<BetDestination, Double> odds;
	Chip_Piles chipPiles;
	
	public Craps_Model(Context context, Activity activity) {
        rand= new Random();
		dice = new int[2];
		wallet=500;
		//bets=new TreeMap<>();
		chipPiles=new Chip_Piles(context, activity);

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



	//	newGame();
	}

	public double getWallet() {
		return wallet;
	}

	private void initializeDice() {
		dice[0]=rand.nextInt(6)+1;
		dice[1]=rand.nextInt(6)+1;
	}

	public String placeBet(BetDestination betDestination, int betValue, int x, int y)	//returns false if insufficient funds
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
					return "That is not allowed on the come out roll.";
			}
		}
		if((betDestination==BetDestination.come)&&chipPiles.contains(BetDestination.dontCome)) {
			return "Cannot bet on Come and Don't Come at the same time.";
		}
		if(wallet >= betValue){
			wallet-=betValue;
			chipPiles.add(x,y,betValue,betDestination);
			return null;
		}
		else {
			return "Insufficient funds";
		}
	}

	/*
	public boolean newGame() // This will clear last game and create a new one.
	{
		point=0;
		comeOutRoll=true;
		return true;
	}
	public boolean loseGame()
	{
		bets.clear();
		return true;
	}
	*/

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

	private double payout(BetDestination betDestination, double multiplier){
		double payout=0;

		if (chipPiles.contains(betDestination)) {
			double winnings=chipPiles.payout(betDestination);
			payout += winnings+(winnings*odds.get(betDestination)*multiplier) ;
			System.out.println("$" + payout + " recieved from " + betDestination);
			wallet += payout;
		}
		return payout;
	}
	
	public Map<BetDestination, Double> rollDice() {
		initializeDice();
		int diceValue=getDiceValue();
		Map<BetDestination, Double> payoutMap = new TreeMap<>();
		if(comeOutRoll) {
			//on first roll, three things can happen
			switch(diceValue) {
				case 2:
				case 3:
				case 12:
					//pass
					payoutMap.put(BetDestination.dontPassBar,payout(BetDestination.dontPassBar));
					chipPiles.remove(BetDestination.passLine);
					break;
				case 7:
				case 11:
					//dont pass
					payoutMap.put(BetDestination.passLine,payout(BetDestination.passLine));
					chipPiles.remove(BetDestination.dontPassBar);
					break;
				default:
					//point
					point=diceValue;
					comeOutRoll=false;
					//TODO:move puck
			}

		}
		else{
			//not the first roll
			if (diceValue==point) {    //if you get your point, win pass
				payoutMap.put(BetDestination.passLine, payout(BetDestination.passLine));
				chipPiles.remove(BetDestination.dontPassBar);
				point=0;
				//TODO: move point puck
			}
		}
//payout for everything else
		switch(diceValue) {
			case 2:
				payoutMap.put(BetDestination.mini2,payout(BetDestination.mini2));
				payoutMap.put(BetDestination.mini_any,payout(BetDestination.mini_any));
				payoutMap.put(BetDestination.field,payout(BetDestination.field, 2));
				break;
			case 3:
				payoutMap.put(BetDestination.mini_any,payout(BetDestination.mini_any));
				payoutMap.put(BetDestination.field,payout(BetDestination.field));
				payoutMap.put(BetDestination.mini3,payout(BetDestination.mini3));
				break;
			case 4:
				payoutMap.put(BetDestination.field,payout(BetDestination.field));
				payoutMap.put(BetDestination.sideBet4,payout(BetDestination.sideBet4));
				chipPiles.remove(BetDestination.dontCome4);
				payoutMap.put(BetDestination.dontCome4, 0.0);
				if (dice[0] == dice[1])
					payoutMap.put(BetDestination.hard4,payout(BetDestination.hard4));
				chipPiles.remove(BetDestination.lay4);
				payoutMap.put(BetDestination.lay4, 0.0);
				move(BetDestination.come, BetDestination.come4);
				move(BetDestination.dontCome, BetDestination.dontCome4);
				break;
			case 5:
				payoutMap.put(BetDestination.sideBet4,payout(BetDestination.sideBet5));
				payoutMap.put(BetDestination.buy5,payout(BetDestination.buy5));
				chipPiles.remove(BetDestination.dontCome5);
				payoutMap.put(BetDestination.dontCome5, 0.0);
				chipPiles.remove(BetDestination.lay5);
				payoutMap.put(BetDestination.lay5, 0.0);
				move(BetDestination.come, BetDestination.come5);
				move(BetDestination.dontCome, BetDestination.dontCome5);

				break;
			case 6:
				payoutMap.put(BetDestination.big6,payout(BetDestination.big6));
				payoutMap.put(BetDestination.sideBet6,payout(BetDestination.sideBet6));
				payoutMap.put(BetDestination.buy6,payout(BetDestination.buy6));
				chipPiles.remove(BetDestination.dontCome6);
				payoutMap.put(BetDestination.dontCome6, 0.0);
				if (dice[0] == dice[1])
					payoutMap.put(BetDestination.hard6,payout(BetDestination.hard6));
				chipPiles.remove(BetDestination.lay6);
				payoutMap.put(BetDestination.lay6, 0.0);
				move(BetDestination.come, BetDestination.come6);
				move(BetDestination.dontCome, BetDestination.dontCome6);
				break;
			case 7:
				payoutMap.put(BetDestination.lay4,payout(BetDestination.lay4));
				payoutMap.put(BetDestination.lay5,payout(BetDestination.lay5));
				payoutMap.put(BetDestination.lay6,payout(BetDestination.lay6));
				payoutMap.put(BetDestination.lay8,payout(BetDestination.lay8));
				payoutMap.put(BetDestination.lay9,payout(BetDestination.lay9));
				payoutMap.put(BetDestination.lay10,payout(BetDestination.lay10));
				payoutMap.put(BetDestination.dontCome4,payout(BetDestination.dontCome4));
				payoutMap.put(BetDestination.dontCome5,payout(BetDestination.dontCome5));
				payoutMap.put(BetDestination.dontCome6,payout(BetDestination.dontCome6));
				payoutMap.put(BetDestination.dontCome8,payout(BetDestination.dontCome8));
				payoutMap.put(BetDestination.dontCome9,payout(BetDestination.dontCome9));
				payoutMap.put(BetDestination.dontCome10,payout(BetDestination.dontCome10));
				payoutMap.put(BetDestination.dontPassBar,payout(BetDestination.dontPassBar));
				payoutMap.put(BetDestination.mini7,payout(BetDestination.mini7));
				payoutMap.put(BetDestination.mini_any,payout(BetDestination.mini_any));
				chipPiles.clearAll();
				break;
			case 8:
				payoutMap.put(BetDestination.big8,payout(BetDestination.big8));
				payoutMap.put(BetDestination.sideBet8,payout(BetDestination.sideBet8));
				payoutMap.put(BetDestination.buy8,payout(BetDestination.buy8));
				chipPiles.remove(BetDestination.dontCome8);
				payoutMap.put(BetDestination.dontCome8, 0.0);
				if (dice[0] == dice[1])
					payoutMap.put(BetDestination.hard8,payout(BetDestination.hard8));
				chipPiles.remove(BetDestination.lay8);
				payoutMap.put(BetDestination.lay8, 0.0);
				move(BetDestination.come, BetDestination.come8);
				move(BetDestination.dontCome, BetDestination.dontCome8);
				break;
			case 9:
				payoutMap.put(BetDestination.field,payout(BetDestination.field));
				payoutMap.put(BetDestination.sideBet9,payout(BetDestination.sideBet9));
				payoutMap.put(BetDestination.buy9,payout(BetDestination.buy9));
				chipPiles.remove(BetDestination.dontCome9);
				payoutMap.put(BetDestination.dontCome9, 0.0);
				chipPiles.remove(BetDestination.lay9);
				payoutMap.put(BetDestination.lay9, 0.0);
				move(BetDestination.come, BetDestination.come9);
				move(BetDestination.dontCome, BetDestination.dontCome9);
				break;
			case 10:
				payoutMap.put(BetDestination.field,payout(BetDestination.field));
				payoutMap.put(BetDestination.sideBet10,payout(BetDestination.sideBet10));
				payoutMap.put(BetDestination.buy10,payout(BetDestination.buy10));
				if (dice[0] == dice[1])
					payoutMap.put(BetDestination.hard10,payout(BetDestination.hard10));
				chipPiles.remove(BetDestination.dontCome10);
				payoutMap.put(BetDestination.dontCome10, 0.0);
				chipPiles.remove(BetDestination.lay10);
				payoutMap.put(BetDestination.lay10, 0.0);
				move(BetDestination.come, BetDestination.come10);
				move(BetDestination.dontCome, BetDestination.dontCome10);
				break;
			case 11:
				payoutMap.put(BetDestination.field,payout(BetDestination.field));
				payoutMap.put(BetDestination.mini11,payout(BetDestination.mini11));
				payoutMap.put(BetDestination.mini_any,payout(BetDestination.mini_any));

				break;
			case 12:
				payoutMap.put(BetDestination.field,payout(BetDestination.field, 3));
				payoutMap.put(BetDestination.mini12,payout(BetDestination.mini12));
				payoutMap.put(BetDestination.mini_any,payout(BetDestination.mini_any));
				break;
		}
			//set point or lose
		if(point==0) {
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
					//loseGame();
					break;
			}
		}
		else{
			if (diceValue==point) {//point get
				payout(BetDestination.passLine);
				chipPiles.remove(BetDestination.dontPassBar);
				payoutMap.put(BetDestination.dontPassBar, 0.0);
			}
			else if(diceValue==7){
				payout(BetDestination.dontPassBar);
				payout(BetDestination.passLine);
			}
		}

		//move for come out, dont come

		//no matter what, clear the one-roll bets
		chipPiles.remove(BetDestination.mini2);
		chipPiles.remove(BetDestination.mini3);
		chipPiles.remove(BetDestination.mini7);
		chipPiles.remove(BetDestination.mini11);
		chipPiles.remove(BetDestination.mini12);
		chipPiles.remove(BetDestination.mini_any);
		payoutMap.put(BetDestination.mini2, 0.0);
		payoutMap.put(BetDestination.mini3, 0.0);
		payoutMap.put(BetDestination.mini7, 0.0);
		payoutMap.put(BetDestination.mini11, 0.0);
		payoutMap.put(BetDestination.mini12, 0.0);
		payoutMap.put(BetDestination.mini_any, 0.0);

		

		return payoutMap;
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
		return chipPiles.getTotalBet();
	}

	public boolean setWallet(double cash){
	    if (cash>=0) {
            wallet = cash;
            return true;
        }
        return false;
    }

	private void move(BetDestination oldDest, BetDestination newDest){
		if (chipPiles.contains(oldDest)) {
			try {
				chipPiles.move(oldDest, newDest);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

    //test functions
	public void displayBets(){
		chipPiles.printMap();

	}


}