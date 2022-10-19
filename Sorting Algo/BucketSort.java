import java.util.*;
 
public class Main 
{
   public static int[] bucket_sort(int[] arr, int max_value) 
    {
        int[] bucket = new int[max_value + 1];
        int[] sorted_arr = new int[arr.length];
 
        for (int i= 0; i <arr.length; i++)
            bucket[arr[i]]++;
 
        int pos = 0;
        for (int i = 0; i < bucket.length; i++)
            for (int j = 0; j < bucket[i]; j++)
                sorted_arr[pos++] = i;
 
        return sorted_arr;
    }
 
 
    static int maxValue(int[] arr) 
    {
        int max_value = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] > max_value)
                max_value = arr[i];
        return max_value;
    }
 
    public static void main(String args[]) 
    {
        int[] arr ={800, 500, 300, 100, 900, 600, 10, 700, 400, 200, 500};
        int max_value = maxValue(arr);
 
        System.out.print("\nOriginal Elements: ");
        System.out.println(Arrays.toString(arr));
 
        System.out.print("\nSorted Elements: ");
        System.out.println(Arrays.toString(bucket_sort(arr,max_value)));
        
    }
}
