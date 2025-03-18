package lc.arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    class Solution {

        //Without map and most optimized
        public int majorityElement(int[] nums) {

            int frequentNumber = 0;
            int frequency = 0;
            for(int num : nums) {
                if(frequency == 0) {
                    frequency = 1;
                    frequentNumber = num;
                } else if(frequentNumber == num) {
                    frequency++;
                } else {
                    frequency--;
                }
            }
            return frequentNumber;
        }

         public int majorityElementWithMap(int[] nums) {
             int size = nums.length;
             Map<Integer, Integer> map = new HashMap<>();
             for(int val : nums) {
                 int count = map.getOrDefault(val, 0);
                 if(count + 1 > size / 2) {
                     return val;
                 }
                 map.put(val, count + 1);
             }
             return -1;
         }
    }
}
