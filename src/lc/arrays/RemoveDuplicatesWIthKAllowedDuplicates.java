package lc.arrays;

public class RemoveDuplicatesWIthKAllowedDuplicates {

    //K number of duplicates allowed, here k = 2,3,....etc
    public int removeDuplicates(int[] nums, int k) {

        if(nums.length <= k) return nums.length;
        int pivot = k;
        int next = k;
        while(next < nums.length) {
            if(nums[next] != nums[pivot - k]) {
                nums[pivot] = nums[next];
                pivot++;
            }
            next++;
        }
        return pivot;
    }
}
