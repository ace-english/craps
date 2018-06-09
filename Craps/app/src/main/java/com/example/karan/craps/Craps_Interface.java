package com.example.karan.craps;

enum BetDestination
{
	passline,
	sidebet4, sidebet5, sidebet6, sidebet8, sidebet9, sidebet10,
	big6, big8,
	field, dontpassbar,
	mini7, mini6, mini8, mini4, mini3, mini2, mini12, mini6_5, mini5_6, mini_any;
}

public interface 	Craps_Interface{
	
	/*functions stubs go here*/
	
	
	boolean placeBet(int betAmount);	//returns false if insufficient funds

	boolean newGame(); // This will clear last game and create a new one.

	int rollDice();   // This will roll the dice and process the result

	boolean loseGame();   // This will excutute a Lose game if the Dice rolls didnt go the players way.

	boolean winGame();	// This will excutute a Win if the Dice rolls went the players way.

	boolean FieldBetPayout();	// This will calculate the FieldBetPayout board if player placed a bet here.

	int getPointValue(); //Returns value of dice
	
	int getDie1() ;	//getter, useful for future graphics

	int getDie2() ;	//getter, useful for future graphics

	int getWallet();	//getter, useful for GUI

	int getTurnNumber(); //getter, useful for GUI

	void betOn(BetDestination betDestination, int betValue); //passes in ID of destination and value to bet
		
}