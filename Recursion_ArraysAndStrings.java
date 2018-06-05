package prolific;

public class Recursion_ArraysAndStrings {
	
	/*1) Compute the value of power function power(x, n),
	     given two integers x (base) and n (exponent, which is non-negative).*/
	
	//1. Bruteforce
	public static int power(int x, int n)
	{
		if(n==0) return 1;
		
		return x * power(x,n-1);	
	}
	
	//optimization
	public static int powerOptimized(int x, int n)
	{
		if(n==0)
			return 1;
		int temp = powerOptimized(x,n/2);
		return x* temp * temp;
	}
	
	/*2) A magic index in an array[0...n-1] is defined to be an index such that A[i] = i.
	 *  Given a sorted array of distinct integers, write a method to find a magic index, if one exists,
	 *  in array A.
	 		 
		Ex: input: [-40, -20, -1, 1, 2 ,3 ,5, 7, 9, 12, 13]
		output: 7
	*/
	 	
	//Bruteforce
	public static int getMagic_helper(int[] nums, int index)
	{
		if(index >= nums.length) return -1;
		if(nums[index] == index)
			return index;
		return getMagic_helper(nums, index+1);
	}
		
	public static int getMagic(int[] nums)
	{
		return getMagic_helper(nums, 0);
	}
		
	//optimized - use Binary search
	public static int getMagicOptimized(int[] nums)
	{
		return getMagic(nums, 0, nums.length-1);
	}
	public static int getMagic(int[] nums, int low, int high)
	{
		if(low>high) return -1;
		int mid = (low+high)/2;
		if(nums[mid] == mid)
			return mid;
		else if (nums[mid] < mid)
		{
			return getMagic(nums,mid+1,high);
		}
		return  getMagic(nums, 0, mid-1);
	}
	
	/*3) Count Spaces in a string.
		When the string is empty it cannot have a space so the count of spaces is 0.
		Using recursive call, check character by character by working with substrings of the string,
		and then sum the counts of the string spaces.*/ 
	
	public static int countSpace(String str)
	{
		if(str.length() == 0) return 0;
		if(str.charAt(0) == ' ')
			return 1 + countSpace(str.substring(1));
		return countSpace(str.substring(1));
	}
	
	public static void main(String[] args) {
		System.out.println("power-bruteforce: "+ power(2,3));		
		System.out.println("Power-Optimized: "+ powerOptimized(2,3));
		System.out.println("Power-Optimized: "+ powerOptimized(5,3));		
		
		int[] nums = {-40, -20, -1, 1, 2 ,3 ,5, 7, 9, 12, 13};
		System.out.println("Magic Index: " + getMagic(nums));
		System.out.println("Magic Index optimized: " + getMagicOptimized(nums));
		
		String str ="a ";// "When the string is  empty";
		System.out.println("Count Spaces:" +countSpace(str));
	}
}
