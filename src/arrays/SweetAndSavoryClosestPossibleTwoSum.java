package arrays;

import java.util.Arrays;

public class SweetAndSavoryClosestPossibleTwoSum {

    public int[] sweetAndSavory(int[] dishes, int target) {

        Arrays.sort(dishes);
        int left = 0;
        int right = dishes.length - 1;
        int[] sol = new int[2];
        int targetSum = target < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        while(left < right && dishes[left] < 0 && dishes[right] > 0) {
            int sum = dishes[left] + dishes[right];
            if(sum == target) {
                sol[0] = dishes[left];
                sol[1] = dishes[right];
                break;
            }
            if(sum < target) {
                if(Math.abs(sum - target) < Math.abs(targetSum - target)) {
                    targetSum = sum;
                    sol[0] = dishes[left];
                    sol[1] = dishes[right];
                }
                left++;
            } else {
                right--;
            }
        }
        return sol;
    }
}
