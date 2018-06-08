package com.example.karan.craps;

enum BetDestination
{

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