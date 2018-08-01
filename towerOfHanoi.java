import java.util.*;
public class towerOfHanoi {

	public static void getMoves(int n, int src, int dest, int temp, ArrayList<Integer[]> result)
	{
		if(n>0)
		{
			getMoves(n-1,src,temp,dest, result);
			Integer[] move = {n, src, dest};
			result.add(move);
			System.out.println("Move disk " + n + "  from " + src + " to " + dest);
			getMoves(n-1,temp,dest,src,result);
		}
	}
	
	public static int[][] towers(int n)
	{
		ArrayList<Integer[]> result = new ArrayList<Integer[]>();
		getMoves(n,1,3,2,result);
		
		int[][] output = new int[result.size()][result.get(0).length];
		
		for(int i=0; i<result.size(); i++)
		{		
			for(int j=0; j<result.get(0).length; j++)
			{
				output[i][j] = result.get(i)[j];
			}
		}
		return output;
	}
	public static void main(String[] args)
	{
		int[][] result = towers(3);
		for(int[] temp:result)
		{			
			System.out.println(Arrays.toString(temp));
		}
	}
}
