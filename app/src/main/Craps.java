import java.util.*

public class Craps{
	
}

class Dice{
	Random r = new Random();
	int dice[2];
	
	public Dice()
	{
		rollDice();
	}
	
	int[] rollDice()
	{
		
		dice[0]=r.nextInt(6)+1;
		dice[1]=r.nextInt(6)+1;
		
		return dice;
	}
	
	int sum()
	{
		return dice[0]+dice[1];
	}
	
	
}
