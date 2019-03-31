package com.badalchowdhary.interviewcake;

/**
 * Given the array of IDs, which contains many duplicate integers and one unique
 * integer, find the unique integer.
 * 
 * @author badalrocks
 *
 */
public class Problem21UniqueInteger
{

    public static int getUniqueDeliveryId(int[] deliveryIdConfirmations)
    {
        // TODO do boundary checks.
        doBoundaryChecksGetUniqueDeliveryId(deliveryIdConfirmations);
        
        int uniqueDeliveryId = 0;
        
        for (int deliveryIdConfirmation : deliveryIdConfirmations)
        {
            uniqueDeliveryId = uniqueDeliveryId ^ deliveryIdConfirmation;
        }
        
        return uniqueDeliveryId;
    }
    
    private static void doBoundaryChecksGetUniqueDeliveryId(int [] deliveryIdConfirmations)
    {
        if (deliveryIdConfirmations == null)
        {
            throw new IllegalArgumentException("dic cannot be null");
        }
        
        if (deliveryIdConfirmations.length < 1)
        {
            throw new IllegalArgumentException("dic cannot be empty");
        }
        
        if (deliveryIdConfirmations.length % 2 != 1)
        {
            throw new IllegalArgumentException("dic length must be odd");
        }
    }
    
    public static void main(String[] args)
    {
        int[] dic1 = {1, 4, 2, 100, 2, 4, 1};
        System.out.println(getUniqueDeliveryId(dic1));

        int[] dic2 = {1, 4, 2, 100, 2, 4};
        System.out.println(getUniqueDeliveryId(dic2));

        int[] dic3 = {1, 1};
        System.out.println(getUniqueDeliveryId(dic3));

    }

}
