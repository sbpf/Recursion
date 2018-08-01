import java.util.*;

public class Expressions {

	static ArrayList<String>  generate_all_expressions(String s, long target) 
    {
        ArrayList<String> result = new ArrayList<String>();
        generateExp(s,target,"",0,result);
        return result;
    }
    
    static void generateExp(String s, long target, String currentExp, int i, ArrayList<String> result)
    { 
        if(i==s.length()-1)
        {
        	if(evaluate(currentExp + s.charAt(s.length()-1)) == target)
                result.add(currentExp + s.charAt(s.length()-1));
                //System.out.println(currentExp + s.charAt(s.length()-1));
        }
        else
        {
        	if(i<s.length()-1)
        	{
        		//no-op - append the digit            	
	            generateExp(s,target,currentExp + s.charAt(i), i+1, result);                
	            
	            //multiplication               
	            generateExp(s,target,currentExp + s.charAt(i) + "*", i+1, result);                
	            
	            //addition
	            generateExp(s,target,currentExp+ s.charAt(i) + "+", i+1, result);
        	}

        }
    }
    
    static long evaluate(String s)
    {
        String subProducts[] = s.split("\\+");
        for(int i=0; i<subProducts.length; i++)
        {
            String operands[] = subProducts[i].split("\\*");
            if(operands.length == 0) break;
            long product = 1;
            for(String op : operands)
            {
                product *= Long.parseLong(op);
            }
            subProducts[i] = Long.toString(product);
        }
        
        long result = 0;
        for(String str: subProducts)
        {
            result += Long.parseLong(str);
        }        
        return result;
    }  
    
	public static void main(String[] args)
	{
		String s = "222";
		ArrayList<String> result = generate_all_expressions(s,6);
		for(String str:result)
			System.out.println(str);		
	}
}
