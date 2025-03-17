package lc.arrays;

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int pivot = 0;
        int next = 1;

        while(next < nums.length) {
            if(nums[pivot] == nums[next]) {
                next++;

            } else {
                pivot++;
                if(pivot != next) { //There are duplicate values
                    int tmp = nums[pivot];
                    nums[pivot] = nums[next];
                    nums[next] = tmp;
                }
                next++;
            }
        }
        return pivot + 1;
    }
}
