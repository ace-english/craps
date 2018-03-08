import java.util.Random;

public class Craps_Model implements Craps_Interface{
	
	
	
	
	private int rollDice()
	{
		int dice[2];
		Random rand= new Random();
		
		dice[0]=rand.nextInt(6)+1;
		dice[1]=rand.nextInt(6)+1;
		
		return dice[0]+dice[1];
	}
}