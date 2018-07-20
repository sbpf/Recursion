
public class SimpleExamples {

	//Check if the string is a palindrome
	public static boolean checkPalindrome(String s)
    {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-zA-Z0-9]", "");        
        int i = 0, j=s.length()-1;
        return isPalindrome(s,i,j);
    }
    
    public static boolean isPalindrome(String s, int i, int j)
    {
        if(i>=j)
            return true;
        if(s.charAt(i) == s.charAt(j))
        {          
        	return isPalindrome(s,i+1,j-1);            
        }
        return false;
    }
    
	//find factorial of a number
	public static int factorial(int num)
	{
		if(num==0)
			return 1;
		return num*factorial(num-1);
	}
		
	//raise the base to exponent
	//approach 1
	public static int Raise(int base, int exponent)
	{
		if(exponent == 0)
			return 1;
		return base * Raise(base, exponent-1);
	}
		
	//approach 2 - optimized
	public static int RaiseOptimized(int base, int exponent)
	{
		if(exponent == 0)
			return 1;
		else
		{
		int half = Raise(base,exponent/2);
		if(exponent%2 == 0)
			return half*half;
		else
			return base*half*half;
		}
	}
		
	//Binary Search
	public static int BSearch(String[] input, String key)
	{
		return BSearch_helper(input,key,0, input.length-1);
	}
	
	public static int BSearch_helper(String[] input, String key, int start, int end)
	{
		System.out.println("starting here"+start);
		System.out.println(end);
		
		if(start>end) 
			return -1;
		int mid = (start+end)/2;
		int compare = input[mid].compareTo(key);
		if(compare == 0) 
			return mid;
		else if(compare>0) 
			return BSearch_helper(input,key,start,mid-1);
		else 
			return BSearch_helper(input,key,mid+1,end);
	}
	
	
	//print binary equivalent number
	public static void printBinary(int n)
	{
		if(n<0)
		{
			System.out.print("-");
			printBinary(Math.abs(n));
		}
		if(n<2)
		{
			System.out.print(n);
			return;
		}
		printBinary(n/2);
		System.out.print(n%2);				
	}
	
	
	public static void main(String[] args)
	{
		String str = new String("lol");
		System.out.println("Is palindrome?" + checkPalindrome(str));
		
		String input[] = {"a", "b","c","what's up", "yes", "zee"};
		System.out.println("Binary Search: "+ BSearch(input,"b"));
		
		int num = 19;
		printBinary(num);
	}
}
