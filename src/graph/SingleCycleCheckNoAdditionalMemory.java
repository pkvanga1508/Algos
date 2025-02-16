package graph;

// array = [2,3,1,-4,-4,2]
// start from any index and move left or right those many number of times (-4 -> move left 4 times)
// you should reach the starting point with all the elements visited only once.
// Effectively making a Single cycle
public class SingleCycleCheckNoAdditionalMemory {

    public static boolean hasSingleCycle(int[] array) {
        // Write your code here.
        int startIndex = 0;
        int numberOfMoves = 0;
        int currIndex = startIndex;
        while(numberOfMoves < array.length) {
            int nextIndex = getNextIndex(currIndex, array[currIndex], array.length);
            currIndex = nextIndex;
            numberOfMoves++;
            if(currIndex == startIndex) break;
        }
        return currIndex == startIndex && numberOfMoves == array.length;
    }

    private static int getNextIndex(int index, int offset, int length) {

        if(Math.abs(offset) > length) offset = offset % length;
        int nextIndex = index + offset;
        if(nextIndex >= 0 && nextIndex < length) return nextIndex;
        if(nextIndex < 0) return nextIndex + length;
        else return nextIndex % length;

    }
}
