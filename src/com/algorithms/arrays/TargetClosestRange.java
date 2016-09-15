package com.algorithms.arrays;

/**
 * Created by yogi 09/14/16.
 */
public class TargetClosestRange {


    public static int findClosestRange(int[] values, int target)
    {
        int distance;
        if( target < values[0]) {
            return values[0];
        }
        else
        {
            distance = Math.abs(target - values[0]);
        }
        int closestElement=1;
        for ( closestElement=1; closestElement< values.length; closestElement++)
        {
           int currentDistance = Math.abs(target - values[closestElement]);
            if(currentDistance >= distance)
            {
               break;
            }else
            {
                distance = currentDistance;
            }
        }

        return values[closestElement-1];
    }
    public static void main(String[] args)
    {
        int[] arr = {5,8,9,22,23,25,29,33,39,41};
        int target = 3;

        System.out.println("Cloest number to target " + target + " is " + findClosestRange(arr,target));
        target = 31;
        System.out.println("Cloest number to target " + target + " is " + findClosestRange(arr,target));

    }
}