
public class BinaryPermutation
{
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
	public static void main(String[] args)
	{
		generateBinaryPermutations(3," ");
	}
}
