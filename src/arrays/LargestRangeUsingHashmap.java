package arrays;

import java.util.HashMap;
import java.util.Map;

//Input - [1,11,3,0,15,5,2,4,10,7,12,6,4,2] //Duplicates allowed
//Output - [0,7]
// Put all the values in a map with visited flag as false
// Loop thru the array and check if the element is already visited then continue with next element
// else
// initialize currCount as 1, and current value as the element
// Check the lowest value in the range starting the current Value, and mark each value as visited and increment the curr count
// Check the highest value in the range starting the current Value, and mark each value as visited and increment the curr count
// If curr count > largest count than we can assign the largest count as curr count and range as smallest and largest value.



public class LargestRangeUsingHashmap {

    public static int[] largestRange(int[] array) {

        int longestCount = 0;
        int[] range = {};

        // Write your code here.
        Map<Integer, Boolean> map = new HashMap<>();
        for(int element: array) {
            map.put(element, false);
        }

        for(int i = 0; i < array.length; i++) {

            if(map.get(array[i])) continue; //Already element is visited.

            int currValue = array[i];
            map.put(currValue, true);
            int currCount = 1;
            int minValue = currValue;
            int maxValue = currValue;

            while(Boolean.TRUE.equals(map.get(minValue - 1))) {
                minValue = minValue - 1;
                currCount++;
                map.put(minValue, true);
            }
            while(Boolean.TRUE.equals(map.get(maxValue + 1))) {
                maxValue = maxValue + 1;
                currCount++;
                map.put(maxValue, true);
            }

            if(currCount > longestCount) {
                longestCount = currCount;
                range = new int[] {minValue, maxValue};
            }
        }


        return range;
    }
}
