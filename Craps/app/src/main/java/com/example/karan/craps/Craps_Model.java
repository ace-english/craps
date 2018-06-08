package com.example.karan.craps;
import java.util.Random;

public class Craps_Model implements Craps_Interface{
	private int wallet, passLineBet, counter;
	private boolean comeOutRoll;
<<<<<<< HEAD:_BLACKRAIN/Craps/app/src/main/java/com/example/karan/craps/Craps_Model.java
	int[] dice;
	
	public Craps_Model(){
		dice=new int[2];
=======
	int dice[] = new int[2];

	public Craps_Model(){
>>>>>>> ee7add76c6bfdee9ed73d49dbe2fe12cbc631bce:Craps/app/src/main/java/com/example/karan/craps/Craps_Model.java
		wallet=500;
		newGame();
	}

	public int getWallet() {
		return wallet;
	}
	
	public int getTurnNumber() {
		return counter;
	}
	
	public boolean placeBet(int betAmount)	//returns false if insufficient funds
	{
		if(wallet >= betAmount)
		{
			wallet-=betAmount;
			passLineBet+=betAmount;
			return true;
		}
		return false;
	}
	
	public boolean newGame() // This will clear last game and create a new one.
	{
		counter=0;
		passLineBet=0;
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
		wallet+=passLineBet;
		return true;
	}
	
	public int rollDice()
	{
		initializeDice();
		
		if(comeOutRoll) {
			switch(getPointValue()) {
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
			counter++;
			if(getPointValue()==7)
				loseGame();
<<<<<<< HEAD:_BLACKRAIN/Craps/app/src/main/java/com/example/karan/craps/Craps_Model.java
			else{
			//else if (getPointValue()==pointTextBox.Text) {
=======
			else /*if (getPointValue()==pointTextBox.Text)*/ {						// Disabled if statement for the moment for we dont have pointTextBox implemented yet.
>>>>>>> ee7add76c6bfdee9ed73d49dbe2fe12cbc631bce:Craps/app/src/main/java/com/example/karan/craps/Craps_Model.java
				//TODO: change pointTextBox to the equivalent for our interface
				//might have to be an argument? not sure
				winGame();
			}
		}
		return dice[0]+dice[1];
	}
<<<<<<< HEAD:_BLACKRAIN/Craps/app/src/main/java/com/example/karan/craps/Craps_Model.java
	private void initializeDice() {
=======

	private int initializeDice() {
>>>>>>> ee7add76c6bfdee9ed73d49dbe2fe12cbc631bce:Craps/app/src/main/java/com/example/karan/craps/Craps_Model.java
		Random rand= new Random();
		
		dice[0]=rand.nextInt(6)+1;
		dice[1]=rand.nextInt(6)+1;
		return dice[0] + dice[1];
	}
	
	public int getPointValue() {
		return getDie1()+getDie2();
	}
	
	public int getDie1() {
		return dice[0];
	}
	
	public int getDie2() {
		return dice[1];
	}
}