import java.util.Random;

public class Craps_Model implements Craps_Interface{
	private int wallet, passLineBet, counter;
	private boolean comeOutRoll;
	int dice[2];
	
	public CrapsModel(){
		wallet=500;
		newGame();
	}
	
	public boolean placeBet(int betAmount)	//returns false if insufficient funds
	{
		if(wallet>= betAmount)
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
		comeOutRoll=false;
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
		return dice[0]+dice[1];
	}
	private initializeDice() {
		Random rand= new Random();
		
		dice[0]=rand.nextInt(6)+1;
		dice[1]=rand.nextInt(6)+1;
	}
	public int getDie1() {
		return dice[0];
	}
	public int getDie2() {
		return dice[1];
	}
}