package arrays;

import java.util.HashSet;
import java.util.Set;

public class ZeroSumSubarrayOptimizedWithSet {

    public boolean zeroSumSubarray(int[] nums) {
        // Write your code here.
        Set<Integer> sums = new HashSet<>();
        int currentSum = 0;
        for(int i : nums) {
            currentSum += i;
            if(i == 0 || currentSum == 0 || !sums.add(currentSum)) {
                return true;
            }
        }
        return false;
    }
}
