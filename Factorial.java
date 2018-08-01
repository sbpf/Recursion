
public class Factorial {

    //find factorial of a number
	public static int factorial(int num)
	{
		if(num==0)
			return 1;
		return num*factorial(num-1);
	}

	//raise the base to exponent
	public static int Raise(int base, int exponent)
	{
		if(exponent == 0)
			return 1;
		return base * Raise(base, exponent-1);
	}
	public static void main(String[] args) {
		System.out.println(factorial(5));

	}
}
