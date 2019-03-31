package com.badalchowdhary.algos.arrays;

public class Moves0sRS
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        int[] arr = {3,0,1,2};
        printArray(arr);
        System.out.println("\n");
        moveZeros(arr);
        printArray(arr);
    }
    
    public static void moveZeros (int[] arr){
        
       
        int count = 0;

        for(int i = 0;i< arr.length; i++)
        {
            if(arr[i]==0) {
                count++;
           }
//           System.out.println("arr[i]: "+arr[i]);
           while (arr[i] !=0 && count > 0) {
               arr[i-count]=arr[i]; 
               arr[i] = 0;
           }
        }
    }
    
    private static void printArray(int[] anArray) {
        for (int i = 0; i < anArray.length; i++) {
           if (i > 0) {
              System.out.print(", ");
           }
           System.out.print(anArray[i]);    
      }
    }

}
