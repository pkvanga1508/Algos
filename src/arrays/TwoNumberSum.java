package arrays;

import java.util.HashSet;

// array = [3,5,-4,8,11,1,-1,6]
// target = 10
// Output = [-1,11]
public class TwoNumberSum {

    public static int[] twoNumberSum(int[] array, int targetSum) {
        // Write your code here.
        var values = new HashSet<Integer>();
        for(int value: array) {
            int target = targetSum - value;
            if(values.contains(target)) {
                return new int[]{value, target};
            }
            values.add(value);
        }
        return new int[]{};
    }
}
