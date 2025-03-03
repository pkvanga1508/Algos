package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Give N x M matrix where 0 -> land, 1 -> water
//Find the length of maximum island with replacing one 1 -> 0 (convert water to land)

public class LongestIsland {

    public int largestIsland(int[][] matrix) {

        int maxIslandLength = 1;
        Map<Integer, Integer> islandLengthMap = new HashMap<>();
        int islandName = 2;
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[0].length; col++) {
                if(matrix[row][col] == 0) {
                    int islandLength = getIslandLength(row, col, matrix, islandName);
                    islandLengthMap.put(islandName, islandLength);
                    islandName++;
                }
            }
        }

        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[0].length; col++) {
                if(matrix[row][col] == 1) {
                    int currLength = 1;
                    Set<Integer> neighbours = getNeighbours(row, col, matrix);
                    for(int neighbour: neighbours) {
                        currLength += islandLengthMap.getOrDefault(neighbour, 0);
                    }
                    if(currLength > maxIslandLength) {
                        maxIslandLength = currLength;
                    }
                }
            }
        }
        // Write your code here.
        return maxIslandLength;
    }

    private static int getIslandLength(int row, int col,
                                       int[][] matrix, int islandName) {

        if(row < 0 || col < 0
                || row >= matrix.length
                || col >= matrix[0].length
                || matrix[row][col] != 0) {
            return 0;
        }

        matrix[row][col] = islandName;

        int left = getIslandLength(row, col - 1, matrix, islandName);
        int right = getIslandLength(row, col + 1, matrix, islandName);
        int top = getIslandLength(row-1, col, matrix, islandName);
        int bottom = getIslandLength(row+1, col, matrix, islandName);

        return 1 + left + right + top + bottom;
    }

    private static Set<Integer> getNeighbours(int row, int col, int[][] matrix) {

        Set<Integer> neighbours = new HashSet<>();
        if(col - 1 >= 0) neighbours.add(matrix[row][col - 1]);
        if(col + 1 < matrix[0].length) neighbours.add(matrix[row][col + 1]);
        if(row - 1 >= 0) neighbours.add(matrix[row - 1][col]);
        if(row + 1 < matrix.length) neighbours.add(matrix[row + 1][col]);
        return neighbours;
    }
}
