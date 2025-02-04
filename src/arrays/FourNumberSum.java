package arrays;

//Sample Input [7,6,4,-1,1,2]
//target sum = 16;

//Output: [[7,6,4,-1], [7,6,1,2]]

//Numbers in Quadruplets -> ascendingOrder
//Quadruplets them self should be ordered in ascending order

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourNumberSum {

    //Form a Hashmap with 2 sums with 2 numbers in Array
    //Move pivot element from begining to end
    //At the Pivot element location all the values to the right check if the diff of (target - (pivot + right index)) is in the hashmap then add to the result triplet
    // **** Dont add the value to Hashtable if value is not present ***** (This creates duplicates)
    //Go from 0th index to pivot element and if the value is not present than add to the hashmap (append to the hashmap) [Because of the below logic]
    //We are going to add a value to Hashmap only when our pivot element is at the second element of the pair (This helps remove duplicates)

    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        // Write your code here.

        List<Integer[]> quadrupleList = new ArrayList<>();
        Map<Integer, List<Integer[]>> map = new HashMap<>();

        for (int pivot = 1; pivot < array.length - 1; pivot++) { //Optimization -> Start from 1 and end one number earlier

            //Going right Just check if the value is there then add to the quadruple
            for(int right = pivot + 1; right < array.length; right++) {

                int value = array[pivot] + array[right];
                int diff = targetSum - value;

                if(map.get(diff) != null) { //If Diff is present than add the resulting quadruple to quadrupleList
                    for(Integer[] diffNumbers : map.get(diff)) {
                        Integer[] quadruple = {array[pivot], array[right], diffNumbers[0], diffNumbers[1]};
                        quadrupleList.add(quadruple);
                    }
                } //If the value is not present in the map dont add the value to map
            }

            //When going left to pivot add to the map if the value is not present or append to the map
            for(int left = 0; left < pivot; left++) {
                int value = array[pivot] + array[left];

                Integer[] twoSumNumbers = {array[left], array[pivot]};
                int sum = array[left] + array[pivot];
                List<Integer[]> twoNumberSumList = map.getOrDefault(sum, new ArrayList<>());
                twoNumberSumList.add(twoSumNumbers);
                map.put(sum, twoNumberSumList);
            }
        }
        return quadrupleList;
    }
}
