import java.util.*;

public class Combinations {
	
	
	static String[] generate_all_subsets(String s)
    {
        ArrayList<String> result = new ArrayList<String>();
        StringBuilder input = new StringBuilder(s);
        subsets(input,result,"");
        
        String[] allSubsets = new String[result.size()+1];
        
        int i=0;
        for(String str: result)
        {
            allSubsets[i++] = str;
        }       
        return allSubsets;
    }
    
    static void subsets(StringBuilder s, ArrayList<String> result, String chosen)
    {
        if(s.length()==0)
        {
            result.add(chosen.toString());           
            return;
        }
        
        char c = s.charAt(0);
        s.deleteCharAt(0);
        
        subsets(s,result,chosen); //unchoose the current Character
        subsets(s,result,chosen+c); //choose the current Character
        
        s.append(c);
    }
    
    static boolean check_if_sum_possible(long[] arr, long k) {
        ArrayList<Long> subset = new ArrayList<Long>();
         return check(arr,k,0,0,subset);
	    }
	    
	    static boolean check(long[] arr, long k, int current, long soFarSum,ArrayList<Long> subset)
	    {
	        if(soFarSum == k && subset.size() != 0)
	        {
	           return true;
	        }
	        if(current == arr.length)
	        {
	           return false;
	        }
	        
	        // choose current
	        long temp = arr[current];
	        subset.add(temp);
	        // recurse
	        boolean include = check(arr,k,current+1,soFarSum+temp,subset);
	        
	        // unchoose current
	        // recurse
	        subset.remove(subset.size()-1);
	        boolean exclude = check(arr,k,current+1,soFarSum, subset);
	        return(include || exclude);
	    }
    
	public static void main(String[] args)
	{		
		String[] result = generate_all_subsets("123");
		for(String str: result)
        {          
            System.out.println(str);
        }
		long arr[] = {2,10,20};
		
		System.out.println(check_if_sum_possible(arr,12));
	}
	
	/*static boolean check_if_sum_possible(long[] arr, long k) {
        
        return check(arr,k,0,0,false);
    }
    
    static boolean check(long[] arr, long k, int current, long soFarSum, boolean nonZeroInput)
    {
        if(soFarSum == k && current > 0)
        {
            //if( soFarSum != 0 || current > 0)
            //if(current > 0 || k != 0)
        	System.out.println("current: " + current + " soFarSum: " + soFarSum);
                return true;
        }
        if(current == arr.length)
        {
           return false;
        }
        
        // choose current
        long temp = arr[current];
        boolean nonZero = temp!=0 ? true: nonZeroInput;
        
        // recurse
        boolean include = check(arr,k,current+1,soFarSum+temp, nonZeroInput);
        
        // unchoose current
        arr[current] = temp;
         // recurse
        boolean exclude = check(arr,k,current+1,soFarSum, nonZeroInput);
        return(include || exclude);
}*/
}
