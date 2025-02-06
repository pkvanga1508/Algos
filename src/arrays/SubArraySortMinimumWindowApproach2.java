package arrays;

//input = [1,2,4,7,10,11,7,12,6,7,16,18,19]
//output = [3,9]

//Going left to right Compare each element to the next element and if the next element is less than the element assign that index to leftIndex,
//otherwise the current element is used to compare the next element.
//Going right to left Compare each element to the before element and if the before element is more than the element assign that index to rightIndex
//otherwise the current element is used to compare the next element.
//Retrun the {rightIndex, leftIndex}

public class SubArraySortMinimumWindowApproach2 {

    public static int[] subarraySort(int[] array) {

        int leftIdx = -1; int rightIdx = -1;

        int leftValueToCompare = array[0];
        for(int i = 1; i < array.length; i++) {
            if(array[i] < leftValueToCompare) {
                leftIdx = i;
            }
            else {
                leftValueToCompare = array[i];
            }
        }

        int rightValueToCompare = array[array.length -1];
        for(int i = array.length - 2; i >= 0; i--) {
            if(array[i] > rightValueToCompare){
                rightIdx = i;
            }
            else {
                rightValueToCompare = array[i];
            }
        }

        return new int[] {rightIdx, leftIdx};
    }
}
