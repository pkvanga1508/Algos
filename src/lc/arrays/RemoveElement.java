package lc.arrays;

//THis is like move the element with val to the end
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {

            if(nums[left] != val) {
                left++;
            }
            else if(nums[right] == val) {
                right--;
            } else { //Here swapping has to happen
                nums[left] = nums[right];
                nums[right] = val;
                left++;
                right--;
            }
        }
        return left;
    }
}
