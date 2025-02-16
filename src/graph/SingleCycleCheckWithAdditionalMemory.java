package graph;

// array = [2,3,1,-4,-4,2]
// start from any index and move left or right those many number of times (-4 -> move left 4 times)
// you should reach the starting point with all the elements visited only once.
// Effectively making a Single cycle

public class SingleCycleCheckWithAdditionalMemory {

    public static boolean hasSingleCycle(int[] array) {
        // Write your code here.
        boolean[] visited = new boolean[array.length];
        int startingIndex = 0;
        int currIndex = startingIndex;
        while(!visited[currIndex]) { //While current index not visited
            visited[currIndex] = true; //Visit current index
            currIndex = getNextIndexToVisit(currIndex, array[currIndex], array.length);
        }
        //If we land back on the same starting Index and all the nodes are visited.
        return (currIndex == startingIndex) && isAllElementsVisited(visited) ;
    }

    private static int getNextIndexToVisit(int currindex, int offset, int length) {
        if(Math.abs(offset) > length) offset = offset % length; //If values like -25 or 25 if the length of array = 9
        int index = currindex + offset;
        if(index >= 0 && index < length) return index;
        if(index >= length) return index % length; //6 -> 0th index -> 6 - 6 = 0;
        else return length + (index % length);
    }

    private static boolean isAllElementsVisited(boolean[] visited) {
        for(boolean elementVisited: visited) {
            if(!elementVisited) return false;
        }
        return true;
    }
}
