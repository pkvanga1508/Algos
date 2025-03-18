package lc.arrays;

public class RotateArray {

    public void rotate(int[] nums, int k) {

        int len = nums.length - 1;
        k = k % len;
        //If we rotate k length array by k times -> we get the original array so no need to rotate
        if (k != 0) {
            rotateArray(nums, 0, nums.length -1);
            rotateArray(nums, 0, k - 1);
            rotateArray(nums, k, nums.length -1);
        }
    }

    private void rotateArray(int[] nums, int startIdx, int endIdx) {
        while(startIdx < endIdx) {
            int tmp = nums[startIdx];
            nums[startIdx] = nums[endIdx];
            nums[endIdx] = tmp;
            startIdx++;
            endIdx--;
        }
    }
}
