package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//"input": [1, 0, 0, 1, 0],
//         [1, 0, 1, 0, 0],
//         [0, 0, 1, 0, 1],
//         [1, 0, 1, 0, 1],
//         [1, 0, 1, 1, 0]
//
//"Output": 1 -> river, 0 -> land
//Need to find the river sizes [1,2,2,2,5]

public class RiverSizesNoAdditionalMemoryRecursive {

    public static List<Integer> riverSizes(int[][] matrix) {
        List<Integer> riverSizes = new ArrayList<Integer>();
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[0].length; col++) {
                if(matrix[row][col] == 0) continue;
                int riverSize = getRiverSize(row, col, matrix, 0);
                riverSizes.add(riverSize);
            }
        }
        return riverSizes;
    }

    private static int getRiverSize(int row, int col, int[][] matrix, int size) {

        if(row < 0 || col < 0
                || row >= matrix.length || col >= matrix[0].length
                || matrix[row][col] == 0) {
            return 0;
        }

        matrix[row][col] = 0; //Mark it as Visited
        int left = getRiverSize(row, col-1, matrix, size); //get size of left river
        int right = getRiverSize(row, col+1, matrix, size); //get size of right river
        int bottom = getRiverSize(row+1, col, matrix, size); //get size of bottom river
        int top = getRiverSize(row-1,col,matrix,size); // get size of top river
        size++; //Increment here
        return size + left + right + bottom + top; //return final size
    }
}
