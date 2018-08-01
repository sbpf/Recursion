import java.util.*;
public class DiceRoll {
	
	//Prob 1: Print all possible outcomes of rolling dice
	//Input: Number of dice
	//Backtracking example
	public static void diceRoll(Integer dice)
	{
		ArrayList<Integer> chosen = new ArrayList<Integer>();
		diceRollHelper(dice,chosen);		
	}
	
	public static void diceRollHelper(Integer dice, ArrayList<Integer> chosen)
	{
		if(dice == 0)
		{
			System.out.println(chosen);
			return;
		}		
		for(int i=1; i<=6; i++)
		{
			chosen.add(i);
			diceRollHelper(dice-1,chosen);
			chosen.remove(chosen.size()-1);
		}		
	}
	
	//Prob 2: Print all oucomes of rolling the dice, that sum up to a given value
	//Input: Number of dice and Required Sum
	public static void diceSum(Integer dice, Integer sum)
	{
		ArrayList<Integer> chosen = new ArrayList<Integer>();
		diceSum(dice, sum, chosen, 0);
	}
	public static void diceSum(Integer dice, Integer sum, ArrayList<Integer> chosen, Integer chosenSum)
	{
		if(dice==0)
		{
			System.out.println(chosen);
			return;
			//Note: can also check if the dice sum up to the expected value.
			//But this is not the efficient place to put that logic.
		}
		for(Integer i=1; i<=6; i++)
		{
			if(chosenSum + i <= sum)
			{		
				chosen.add(i);
				diceSum(dice-1, sum-i, chosen, chosenSum+i);
				chosen.remove(chosen.size()-1);
			}
		}
	}
	
	//with better checks
	public static void diceSumbetter(Integer dice, Integer desiredSum, ArrayList<Integer> chosen, Integer sumSoFar)
	{
		if(dice==0)
		{
			if(sumSoFar == desiredSum)
				System.out.println(chosen);
			return;			
		}
		else
		{
			for(Integer i=1; i<=6; i++)		
			{
				//if(chosenSum + i <= sum)
				if((sumSoFar + i + 1*(dice-1) <= desiredSum)
					&& (sumSoFar + i + 6*(dice-1) >= desiredSum))
				{		
					chosen.add(i);
					diceSumbetter(dice-1, desiredSum, chosen, sumSoFar+i);
					chosen.remove(chosen.size()-1);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		//diceSum(2,7);
		ArrayList<Integer> chosen = new ArrayList<Integer>();
		Integer dice = 2;
		Integer sum = 7;
		Integer sumSoFar = 0;
		diceSumbetter(dice,sum,chosen,sumSoFar);
	}
}
