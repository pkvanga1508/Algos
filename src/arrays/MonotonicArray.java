package arrays;

//input array either increasing or decreasing (can have same value too)
//[1, 1, 2, 3, 4, 5, 5, 5, 6, 7, 8, 7, 9, 10, 11] -> True as Monotonically increasing
// [-1, -1, -2, -3, -4, -5, -5, -5, -6, -7, -8, -7, -9, -10, -11] -> True as Monotonically decreasing

//Compare the first and last elements and check if they are increasing or not
//Loop thru all the elements and compare with the next element.
//If its increasing check if a pair is decreasing then return false
//If its not increasing check if a pair is increasing then trturn false
//Else at the end of loop return true.
public class MonotonicArray {

    public static boolean isMonotonic(int[] array) {

        if(array.length < 2 ) return true;
        boolean isIncreasing = array[0] < array[array.length -1];
        for(int i = 1; i < array.length -1; i++) {
            if(isIncreasing && array[i-1] > array[i]) return false;
            if(!isIncreasing && array[i-1] < array[i]) return false;
        }
        return true;
    }
}
