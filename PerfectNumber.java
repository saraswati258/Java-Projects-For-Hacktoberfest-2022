/*A perfect number is a positive integer which is equal to the sum of its proper positive divisors. 
Proper positive divisors are positive integers that fully divide the perfect number without leaving a remainder and exclude the perfect number itself.
For example, take the number 6: 
Its proper divisors are 1, 2, and 3 (since 6 is the value of the perfect number, it is excluded), and the sum of its proper divisors is 1 + 2 + 3 = 6. 

Therefore, 6 is a perfect number (as well as the first perfect number).*/

public class PerfectNumber {
    // write your code here

	public static void main(String[] args) {
          boolean isPerfect=isPerfectNumber(6);
          System.out.println(isPerfect);
	}
  
 public static boolean isPerfectNumber(int number) {
        int a = 0;
        int b = 0,sum=0;
        if (number >= 1) 
        {
            for (int i = 1; i<=number/2;  i++)
            {
              if(number%i==0) {
              sum=sum+i;
              if(sum==number)
                  return true;
              }
            }
        }
        
            return false;
        
    }
 
}