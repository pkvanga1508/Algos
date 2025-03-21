package dynamicprogramming;

public class KadenesAlgorithm {

    public static int kadanesAlgorithm(int[] array) {

        if(array.length == 0) return 0;
        int maxSum = array[0];
        int currSum = array[0];
        for(int i = 1; i < array.length; i++) {
            currSum = Math.max(array[i], currSum + array[i]);
            if(currSum > maxSum) {
                maxSum = currSum;
            }
        }
        // Write your code here.
        return maxSum;
    }
}
