

package Java-Projects-For-Hacktoberfest-2022;
import java.util.*;
class Calculator
{
 public class Calculator
 {
    public static void main(String ar[])
    {
        Scanner sc=new Scanner(System.in);
        int ch,a,b;
        float c,d;
        System.out.println("****** Enter your choice ******");
        System.out.println("1.Press 1 for Addition");
        System.out.println("2.Press 2 for Subtract");
        System.out.println("3.Press 3 for Multiply");
        System.out.println("4.Press 4 for Divison");
        ch=sc.nextInt();
        switch(ch)
        {
            case 1:
            System.out.println("Enter the two numbers:");
            a=sc.nextInt();
            b=sc.nextInt();
            System.out.println("The addition is:"+(a+b));
            break;

            case 2:
            System.out.println("Enter the two numbers:");
            a=sc.nextInt();
            b=sc.nextInt();
            System.out.println("The Subtract is:"+(a-b));
            break;

            case 3:
            System.out.println("Enter the two numbers:");
            a=sc.nextInt();
            b=sc.nextInt();
            System.out.println("The Multiplication is:"+(a*b));
            break;

            case 4:
            System.out.println("Enter the two numbers:");
            c=sc.nextFloat();
            d=sc.nextFloat();
            System.out.println("The Divison is:"+(c/d));
            break;

            default:
            System.out.println("Invalid Choice");
            break;
       }

    }
}
