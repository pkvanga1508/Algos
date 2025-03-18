package arrays;

public class ZeroSumSubarray {

    public boolean zeroSumSubarray(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int sum = calculateSum(nums, start, end);
            if(sum == 0) return true;
            if(Math.abs(sum - nums[start]) < Math.abs(sum - nums[end])) {
                start++;
            } else {
                end--;
            }
        }
        return false;
    }

    public int calculateSum(int[] nums, int start, int end) {
        int sum = 0;
        for(int i = start; i <= end; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
