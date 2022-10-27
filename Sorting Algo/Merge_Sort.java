public class Merge_Sort {
    public static int[] sort(int arr1[],int arr2[]){
        int m = arr1.length;
        int n = arr2.length;

        int arr3[] = new int[m+n];
   int i = 0;
   int j = 0;
   int k = 0;

   while (i<m&&j<n){

       if(arr1[i]<=arr2[j]){
           arr3[k] = arr1[i];
           i++;
           k++;
       }
       else {
           arr3[k] = arr2[j];
           j++;
           k++;
       }
   }
   if(m>n){

       while (i<m){
           arr3[k] = arr1[i];
           i++;
           k++;
       }
   }
   else{
       while (j<n){
           arr3[k] = arr2[j];
           j++;
           k++;
       }
   }
   return arr3;
    }
    public static void main(String[] args) {

        int arr1[] = {1,3,5};
        int arr2[] = {2,4,6,7,8};

        int arr3[] = sort(arr1,arr2);

        for(int i :arr3){
            System.out.print(i+" ");
        }

    }
}


