package arrays;

//ArrayOne = [-1,5,10,20,28,3]
//ArrayTwo = [26,134,135,15,17]


import java.util.Arrays;

//Output: [28,26] - First number in the resultant array is element from first array.


//Here once we sort the arrays and start comparing form 0th index on both arrays we
//have to determine which pointer to move
//**** Our goal is to reduce the difference so we have to move the pointer (Think this visually) of the smaller of the two elements. ****

public class SmallestPairDiff {

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {

        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        Integer diff = Integer.MAX_VALUE;
        int[] smallestDiffPair = {};
        int i = 0;
        int j = 0;

        while(i < arrayOne.length &&  j < arrayTwo.length) {

            int currentDiff = Math.abs(arrayOne[i] - arrayTwo[j]);
            if(currentDiff < diff) {
                diff = currentDiff;
                smallestDiffPair = new int[]{arrayOne[i], arrayTwo[j]};
            }
            if(arrayOne[i] == arrayTwo[j]) return smallestDiffPair;
            if(arrayOne[i] < arrayTwo[j]) i++;
            else j++;
        }
        // Write your code here.
        return smallestDiffPair;
    }

}
