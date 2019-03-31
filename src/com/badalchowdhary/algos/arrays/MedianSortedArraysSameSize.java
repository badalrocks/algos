package com.badalchowdhary.algos.arrays;

public class MedianSortedArraysSameSize
{

    private static double getMedianHelper(int[] a, int[] b, int aLow, int aHigh, int bLow, int bHigh)
    {

        if (aHigh - aLow + 1 == 2 || aHigh - aLow + 1 == 1 )
        {
            return (Math.max(a[aLow], b[bLow]) + Math.min(a[aHigh], b[bHigh])) / 2.0;
        }

        double aMed = getMedian(a, aLow, aHigh);
        double bMed = getMedian(b, bLow, bHigh);

        if (aMed == bMed)
        {
            return aMed;
        }

        int aMedIdx = getMedianIndex(a, aLow, aHigh);
        int bMedIdx = getMedianIndex(b, bLow, bHigh);

        if (aMed > bMed)
        {
            return getMedianHelper(a, b, aLow, aMedIdx, bMedIdx, bHigh);
        }
        else
        {
            return getMedianHelper(a, b, aMedIdx, aHigh, bLow, bMedIdx);
        }

    }

    private static double getMedian(int[] arr, int low, int high)
    {
        int numElements = high - low + 1;

        if (numElements % 2 == 1)
        {
            return arr[(low + high) / 2];
        }
        else
        {
            int mid1 = (low + high) / 2;
            int mid2 = mid1 + 1;

            return (arr[mid1] + arr[mid2]) / 2;
        }

    }

    private static int getMedianIndex(int[] arr, int low, int high)
    {
        int numElements = high - low + 1;

        if (numElements % 2 == 1)
        {
            return (low + high) / 2;
        }
        else
        {
            return ((low + high) / 2) + 1;
        }

    }

    public static void main(String[] args)
    {
        int ar1[] = { 1, 12, 15, 26, 38};
        int ar2[] = { 2, 13, 17, 30, 45 };

        double median = getMedianHelper(ar1, ar2, 0, ar1.length - 1, 0, ar2.length - 1);

        System.out.println("median: " + median);

    }

}
