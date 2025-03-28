package dynamicprogramming;

public class LengthOfLongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {

        if(nums.length == 0 || nums.length == 1) return  nums.length;
        int longestSubsequence = 0;
        int[] lis = new int[nums.length];
        lis[lis.length - 1] = 1; //Largest increasing subsequence starting from last index = 1

        for(int i = lis.length - 2; i >= 0; i--) {
            int currSubsequencelength = 1;
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] < nums[j])
                    currSubsequencelength = Math.max(currSubsequencelength, 1 + lis[j]);
            }
            lis[i] = currSubsequencelength;
            if(currSubsequencelength > longestSubsequence) {
                longestSubsequence = currSubsequencelength;
            }
        }
        return longestSubsequence;
    }
}
