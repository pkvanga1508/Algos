package arrays;

import java.util.Arrays;

public class MissingTwoNumbers {

    public int[] missingNumbers(int[] nums) {
        int range = nums.length + 2;
        int rangeSum = ((range) * (range + 1))/2;
        int numSum = Arrays.stream(nums).sum();
        int missingSum = rangeSum - numSum;
        int missingSumAverage = missingSum/2;
        int numLeftSum = Arrays.stream(nums).filter(val -> val <= missingSumAverage).sum();
        int missingSumAverageSum = ((missingSumAverage) * (missingSumAverage + 1))/2;
        int leftNum = missingSumAverageSum - numLeftSum;
        int rightNum = rangeSum - (numSum + leftNum);
        return new int[]{leftNum, rightNum};
    }
}
