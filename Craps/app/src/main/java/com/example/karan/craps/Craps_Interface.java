package com.example.karan.craps;

import java.util.Map;

enum BetDestination
{
	passLine,
	come, dontCome,
	come4, come5, come6, come8, come9, come10,
	dontCome4, dontCome5, dontCome6, dontCome8, dontCome9, dontCome10,
	sideBet4, sideBet5, sideBet6, sideBet8, sideBet9, sideBet10,
	big6, big8,
	field, dontPassBar,
	mini7, hard6, hard10, hard8, hard4, mini2, mini3, mini12, mini11, mini_any,
    buy4, buy5, buy6, buy8, buy9, buy10,
    lay4, lay5, lay6, lay8, lay9, lay10;
}

public interface 	Craps_Interface{
	
	/*functions stubs go here*/
	
	
	String placeBet(BetDestination betDestination, int betValue, int x, int y); //passes in ID of destination and value to bet
																	//requires coordinate touched for chip placement
																	// returns false if insufficient funds

	//boolean newGame(); // This will clear last game and create a new one.

	Map<BetDestination, Double> rollDice();   // This will roll the dice and process the result. Returns payout map

	//boolean loseGame();   // This will execute a Lose game if the Dice rolls didn't go the players way.

	double payout(BetDestination betDestination); //handles payout when player wins a bet. Returns value paid out.

	int getPointValue(); //Returns value of point
	
	int getDie1() ;	//getter for graphics

	int getDie2() ;	//getter for graphics

	double getWallet();	//getter, useful for GUI

	double getTotalBet(); //getter, useful for GUI

	boolean setWallet(double cash); //for loading game

	boolean isFirstTurn();


		
}