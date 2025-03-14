package arrays;

public class LongestPeak {

    public static int longestPeak(int[] array) {

        int maxPeak = 0;
        for(int index = 1; index < array.length - 1; index++) {

            if(array[index] > array[index -1] && array[index] > array[index + 1]) {

                int leftIndex = index;
                int rightIndex = index;
                while((leftIndex > 0) && array[leftIndex - 1] < array[leftIndex]) {
                    leftIndex = leftIndex - 1;
                }
                while((rightIndex < array.length - 1) && array[rightIndex] > array[rightIndex+1]) {
                    rightIndex = rightIndex + 1;
                }
                int currLength = rightIndex - leftIndex + 1;
                if(currLength > maxPeak) maxPeak = currLength;
                index = rightIndex; //Skip till end of the peak
            }
        }

        // Write your code here.
        return maxPeak;
    }
}
