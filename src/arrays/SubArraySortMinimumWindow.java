package arrays;

//input = [1,2,4,7,10,11,7,12,6,7,16,18,19]
//output = [3,9]

//Find all the elements that are out of order -> ie (arr[i-1] > arr[i]) || (arr[i] > arr[i+1])
//Find the Min and Max elements that are out of order
//Try to Place the min element from start of the index and get the index position where it fits
//Try to Place the max element from end of the index and get the index position where it fits
//Return the index where the min and max elements fit
public class SubArraySortMinimumWindow {

    public static int[] subarraySort(int[] array) {

        //If there are only 2 elements
        if (array.length == 2) {
            if (array[0] < array[1]) {
                return new int[]{-1, -1};
            } else {
                return new int[]{0, 1};
            }
        }

        int minMisplacedValue = Integer.MAX_VALUE;
        int maxMisplacedValue = Integer.MIN_VALUE;
        int startIndex = -1;
        int endIndex = -1;

        for (int i = 1; i < array.length - 1; i++) {
            if ((array[i] > array[i + 1]) || (array[i - 1] > array[i])) { //Item is misplaced
                int currMin = Math.min(array[i - 1], Math.min(array[i], array[i + 1]));
                int currMax = Math.max(array[i - 1], Math.max(array[i], array[i + 1]));
                if (currMin < minMisplacedValue) {
                    minMisplacedValue = currMin;
                }
                if (currMax > maxMisplacedValue) {
                    maxMisplacedValue = currMax;
                }
            }
        }

        if (minMisplacedValue == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }


        for (int i = 0; i < array.length; i++) {
            if (array[i] > minMisplacedValue) {
                startIndex = i;
                break;
            }
        }

        for (int j = array.length - 1; j >= 0; j--) {
            if (array[j] < maxMisplacedValue) {
                endIndex = j;
                break;
            }
        }

        return new int[]{startIndex, endIndex};
    }
}
