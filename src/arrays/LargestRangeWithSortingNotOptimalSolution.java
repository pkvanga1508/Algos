package arrays;

import java.util.Arrays;

//Input - [1,11,3,0,15,5,2,4,10,7,12,6,4,2] //Duplicates allowed
//Output - [0,7]
//Sort the Array
//Check for current numbers if they are in sequence
//If current number is in sequence then increment current count and also keep track of the number (large number);
//If current number is not in sequence and current count > large count (or final count) then large count = current count and
// range is from {large Number - large count + 1 , large Number}


public class LargestRangeWithSortingNotOptimalSolution {

    public static int[] largestRange(int[] array) {

        Arrays.sort(array);
        int largeCount = 0;
        int[] range = {};
        int currCount = 1; //Atleast 1 number possible
        int largeValue = Integer.MIN_VALUE;

        if(array.length == 1) {
            return new int[] {array[0], array[0]};
        }
        for(int i = 1; i < array.length; i++) {
            if(array[i-1] == array[i]) continue; //Duplicate Value
            if(array[i-1] + 1 == array[i]) {
                currCount++;
                largeValue = array[i];
            } else {
                if(currCount > largeCount) {
                    largeCount = currCount;
                    currCount = 1;
                    range = new int[] {largeValue - largeCount + 1, largeValue};
                }
            }
        }

        //This is when the else block is not reached in the loop and the array processing is finished.
        if(currCount > largeCount) {
            largeCount = currCount;
            range = new int[] {largeValue - largeCount + 1, largeValue};
        }
        // Write your code here.
        return range;
    }
}
