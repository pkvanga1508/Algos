package arrays;

import java.util.HashSet;
import java.util.Set;

public class FirstDuplicateValueOptimized {

    public int firstDuplicateValue(int[] array) {
        // Write your code here.
        Set<Integer> vals = new HashSet<>();
        for(int val : array) {
            if(!vals.add(val)) {
                return val;
            }
        }
        return -1;
    }
}
