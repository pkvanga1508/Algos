package arrays;

//Input [1,2,3,4]
//Valid sub sequence - [1,2,3,4], [1,3], [1,3,4], [2,4]

import java.util.List;
import java.util.Objects;

//Loop thru both the array and sequence from begining
//If both the values are same then increment both the indexes by 1
//Otherwise just increment the index of array but not subsequence
//At the end check if the sequence index is run completely.
public class ValidateSubsequence {

    public static boolean isValidSubsequence(List<Integer> array,
                                             List<Integer> sequence) {
        int arrayIndex = 0;
        int sequenceIndex = 0;
        while(arrayIndex < array.size() && sequenceIndex < sequence.size()) { //Make sure no array out of bound exceptions

            if(Objects.equals(array.get(arrayIndex), sequence.get(sequenceIndex))) {
                arrayIndex++;
                sequenceIndex++;
            } else {
                arrayIndex++;
            }
        }

        return sequenceIndex == sequence.size(); //We ran thru the entire sequence
    }

}
