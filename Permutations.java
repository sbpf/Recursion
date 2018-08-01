import java.util.Arrays;

public class Permutations {

	//Problem1: Print all permutations of a string
	public static void printPermutations(String str)
	{
		char[] input = str.toCharArray();
		printPermutations(input,0);
	}
	
	public static void printPermutations(char[] input, int i)
	{
		int len = input.length;
		if(i==len-1)
		{
			System.out.println(input);
			return;
		}
		
		for(int j=i; j<len; j++)
		{
			swap(input,i,j);
			printPermutations(input,i+1);
			swap(input,i,j);
		}
	}	
	public static void swap(char[] arr, int i, int j)
	{
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	//Problem 2: Generate permutations of an integer array such that there are even and odd digits in alternating positions	
	public static void permuteEvenOdd(int[] input, int i)
	{
		int len = input.length;
		if(i==len-1)
		{
			System.out.println(Arrays.toString(input));
			return;
		}
		
		for(int j=i; j<len; j++)
		{
			//have to put input[j] in position of i
			//check if that would be valid
			if(isValid(input[j],i))
			{
				swap(input,i,j);
				permuteEvenOdd(input,i+1);
				swap(input,i,j);
			}
		}
	}
	public static boolean isValid(int num, int position)
	{
		if((num%2 == 0 && position%2 == 1) || (num%2==1 && position%2 == 0))
			return true;
		return false;
	}
	
	public static void swap(int[] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	
	/*Problem 3: Permuatation - Print Valid dictionary word
	public static void printValidWords(String str)
	{
		printValidWords(str.toCharArray(),0);
	}
	public static void printValidWords(char arr[], int i)
	{
		int len = arr.length;
		if(i==len-1)
		{
			if(ValidWord(arr))
				System.out.println(arr);
			return;
		}
		else if(ValidWordPrefix(arr.toString().substring(0,i)))
		{
			for(int j= i; j<len; j++)
			{
				swap(arr,i,j);
				printValidWords(arr,i+1);
				swap(arr,i,j);
			}				
		}			
	}*/
	
	//Print all binary permutations of given length
	//For ex: given 3, generate all from 000 to 111	
	public static void generateBinaryPermutations(int digits, String prefix)
	{
		//base case
		if(digits == 0)
		{
			System.out.println(prefix);
			return;
		}
		//recursive
		generateBinaryPermutations(digits-1, prefix + "0");
		generateBinaryPermutations(digits-1, prefix + "1");
	}
	
	public static void generateDecimalPermutations(int digits, String prefix)
	{
		if(digits == 0)
		{
			System.out.println(prefix);
			return;
		}
		
		for(int i=0; i<=9; i++)
		{
			generateDecimalPermutations(digits-1, prefix+i);
		}		
	}
	
	//Find all well formed brackets
	
	
	public static void main(String[] args)
	{		
		/*String str = "sindhu";
		printPermutations(str);
		
		int[] num = {2,3,4,6,5,7};
		permuteEvenOdd(num,0);*/
		
		generateDecimalPermutations(2," ");
	}

}
