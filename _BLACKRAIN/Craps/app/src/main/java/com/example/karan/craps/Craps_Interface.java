public interface Craps_Interface{
	
	/*functions stubs go here
	 */
	
	
	public boolean placeBet(int betAmount);	//returns false if insufficient funds

	public boolean newGame(); // This will clear last game and create a new one.

	public int rollDice();   // This will roll the dice and process the result

	public boolean loseGame();   // This will excutute a Lose game if the Dice rolls didnt go the players way.

	public boolean winGame();	// This will excutute a Win if the Dice rolls went the players way.

	public boolean FieldBetPayout();	// This will calculate the FieldBetPayout board if player placed a bet here.

	public int getPointValue(); //Returns value of dice
	
	public int getDie1() ;	//getter, useful for future graphics
	public int getDie2() ;	//getter, useful for future graphics
	public int getWallet();	//getter, useful for GUI
	public int getTurnNumber(); //getter, useful for GUI
	
	
}