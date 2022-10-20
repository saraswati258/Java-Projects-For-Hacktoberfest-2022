// Sieve of Eratosthenes
import java.util.Scanner;
import java.lang.Math;
class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Starting number: ");
		int st = sc.nextInt();
		System.out.print("Enter the Last number: ");
		int end = sc.nextInt();
		int[] isPrime = new int[end+1];
		isPrime[0] = 1;
		isPrime[1] = 1;
		for(int i=2; i<Math.sqrt(end+1); i++) {
			if (isPrime[i] == 1){
				continue;
			} else {
				for(int j=i*i; j<end+1; j+=i){
					isPrime[j] = 1;
				}
			}
		}
		System.out.println("Prime numbers in range "+st+" to "+end+":");
		for(int i=st; i<end+1; i++){
			if (isPrime[i] == 0) System.out.print(i+" ");
		}
	}
}
