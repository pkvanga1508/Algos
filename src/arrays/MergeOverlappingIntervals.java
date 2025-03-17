package arrays;

import java.util.Arrays;
import java.util.Comparator;

public class MergeOverlappingIntervals {

    public static int[][] mergeOverlappingIntervals(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));

        int numberOfMerges = 0;
        int i = 0;
        int j = 1;
        while(j < intervals.length) {
            if(canMerge(intervals, i, j)) {
                System.out.println(intervals[i][0] + " , " + intervals[i][1]);
                if(intervals[i][1] < intervals[j][1]) {
                    intervals[i][1] = intervals[j][1];
                }
                intervals[j][0] = Integer.MIN_VALUE;
                intervals[j][1] = Integer.MAX_VALUE;
                numberOfMerges++;
                j++;
            } else {
                i = j;
                j = i + 1;
            }
        }
        return getMergedIntervels(intervals, numberOfMerges);
    }

    public static boolean canMerge(int[][] intervals, int i, int j) {
        return intervals[i][1] >= intervals[j][0];
    }

    public static int[][] getMergedIntervels(int[][] intervals, int numberOfMerges) {

        int[][] result = new int[intervals.length - numberOfMerges][2];
        int resultIndex = 0;
        for (int counter = 0; counter < intervals.length; counter++) {
            if(intervals[counter][0] != Integer.MIN_VALUE
                    && intervals[counter][1] != Integer.MAX_VALUE) {
                result[resultIndex] = intervals[counter]; //Check if this throws compilation error
                resultIndex++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] intervels = {{89, 90}, {-10, 20}, {-50, 0}, {70, 90}, {90, 91}, {90, 95}};
        int[][] values = mergeOverlappingIntervals(intervels);
        System.out.println(values);
    }
}
