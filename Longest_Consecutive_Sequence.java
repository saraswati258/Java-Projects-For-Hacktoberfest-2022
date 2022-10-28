// Longest Consecutive Sequence
// Problem Statement:
/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence 
such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order. 
*/
/*
Intution:
 We attempt to build sequences from numbers that are not already part of a longer sequence. 
 This is accomplished by first ensuring that the number that would immediately precede the current number
 in a sequence is not present, as that number would necessarily be part of a longer sequence.
 */

// TC-> O(n) | SC-> O(n)
import java.io.*;
import java.util.*;

class LCS {
	// Returns length of the longest
	// consecutive subsequence
	static int findLongestConseqSubseq(int arr[], int n)
	{
		HashSet<Integer> S = new HashSet<Integer>();
		int ans = 0;

		// Insert all the array elements in hash set
		for (int i = 0; i < n; ++i)
			S.add(arr[i]);

		// check each possible sequence from the start
		// then update optimal length
		for (int i = 0; i < n; ++i) {
			// if current element is the starting
			// element of a sequence
			if (!S.contains(arr[i] - 1)) {
				// Then check for next elements
				// in the sequence
				int j = arr[i];
				while (S.contains(j))
					j++;

				// update optimal length if this
				// length is more
				if (ans < j - arr[i])
					ans = j - arr[i];
			}
		}
		return ans;
	}

	public static void main(String args[])
	{
		int arr[] = {0,3,7,2,5,8,4,6,0,1};
		int n = arr.length;
		System.out.println("Length of the Longest consecutive subsequence is "+ findLongestConseqSubseq(arr, n));
	}
}
