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

    //Approach 2
    public int removeDuplicatesApproach2(int[] nums) {

        if(nums.length <= 1) return nums.length;

        int pivot = 1;
        int next = 1;

        while(next < nums.length) {
            if(nums[next] != nums[pivot -1]) {
                nums[pivot] = nums[next];
                pivot++;

            }
            next++;
        }
        return pivot;
    }

}
