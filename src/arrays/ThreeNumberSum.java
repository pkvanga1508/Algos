package arrays;


//Sample Input [12,3,1,2,-6,5,-8,6]
//target sum = 0;

//Output: [[-8,2,6], [-8.3.5], [-6,1,5]]

//Numbers in Triplet -> ascendingOrder
//Triplets them self should be ordered in ascending order

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {


    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        // Write your code here.
        var tripletList = new ArrayList<Integer[]>();
        Arrays.sort(array);
        for(int pivot = 0; pivot < array.length - 2; pivot++) {
            int start = pivot + 1;
            int end = array.length -1;
            while(start < end) {
                int value = array[pivot] + array[start] + array[end];
                System.out.println("Pivot: " + pivot + " Value: " + value + " Start: " + start + " End: " + end + " StartValue: " + array[start] + " EndValue: " + array[end]);

                if(value == targetSum) {
                    Integer[] triplet = {array[pivot], array[start], array[end]};
                    tripletList.add(triplet);
                    start++; //We have to move start and end index as there may be multiple triplets with Pivot Element.
                    end--;
                } else if(value > targetSum) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return tripletList;
    }

    public static void main(String[] args) {

    }

}
