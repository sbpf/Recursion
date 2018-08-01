import java.util.Arrays;

public class NQueens {
	
	//Print NQueens arrangement, given the number of rows in a chess board
	public static void printNQueens(int n)
	{
		int[] q = new int[n];
		System.out.println(printNQueens(n,0, q));
	}
	
	public static boolean printNQueens(int n, int r, int[] q)
	{
		if(r==q.length)
		{
			System.out.println(Arrays.toString(q));
			return true;
		}
		
		for(int c = 0; c<n; c++)
		{
			q[r] = c;
			if(isValid(q,r) && printNQueens(n, r+1, q))
				return true;			
		}
		return false;
	}
	
	public static boolean isValid(int[] q, int r)
	{
		for(int i=0; i<r; i++)
		{
			if(q[r] == q[i] || Math.abs(q[i] - q[r]) == Math.abs(i-r))
			{
				return false;
			}
		}
		return true;
	}
	
	
	//Print all the possible NQueens arrangements
	public static void printAllArrangements(int n)
	{
		int[] q = new int[n];
		printAllArrangements(n,0,q);
	}
	
	public static void printAllArrangements(int n, int r, int[] q)
	{
		if(r==n)
		{
			System.out.println(Arrays.toString(q));
		}
		else
		{
			for(int c = 0; c<n; c++)
			{			
				if(isValidArrangement(q,r,c))			
				{				
					q[r] = c;
					printAllArrangements(n,r+1,q);				
				}
			}
		}
	}
	public static boolean isValidArrangement(int[] q, int r, int c)
	{
		for(int i=0; i<r; i++)
		{
			if(c == q[i] || Math.abs(q[i] - c) == Math.abs(i-r))
			{
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		printNQueens(4);
		printAllArrangements(4);
	}

}
