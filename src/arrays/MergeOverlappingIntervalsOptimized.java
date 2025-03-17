package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeOverlappingIntervalsOptimized {

    public static int[][] mergeOverlappingIntervals(int[][] intervals) {

        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));

        int[] previousInterval = intervals[0];

        for(int i = 1; i < intervals.length; i++) {
            int[] currInterval = intervals[i];
            if(previousInterval[1] >= currInterval[0]) { //Merge
                previousInterval[1] = Math.max(previousInterval[1], currInterval[1]);
            }
            else {
                result.add(previousInterval); //Add the previous interval.
                previousInterval = currInterval; //Swap previous with current.
            }

            if(i == intervals.length -1) { //if we reach the end
                result.add(previousInterval);
            }
        }
        return result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args) {
        int[][] intervels = {{89, 90}, {-10, 20}, {-50, 0}, {70, 90}, {90, 91}, {90, 95}};
        int[][] values = mergeOverlappingIntervals(intervels);
        System.out.println(values);
    }
}
