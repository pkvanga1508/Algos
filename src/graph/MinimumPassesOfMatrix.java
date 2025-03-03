package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Given a Matrix of +ve, -ve, 0 elements
//Find out the number of passes required to change a -ve value to positve
//-ve value is changed to +ve if it is surrouned by a +ve value. (up, down, left and right)
public class MinimumPassesOfMatrix {

    public int minimumPassesOfMatrix(int[][] matrix) {

        int passes = 0;
        Queue<Integer[]> queue = new LinkedList<>();

        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[0].length; col++) {
                if(matrix[row][col] > 0) {
                    queue.add(new Integer[]{row, col});
                }
            }
        }

        while(true) {
            int size = queue.size();
            if(size == 0) break;
            for(int count = 0; count < size; count++) {
                Integer[] index = queue.poll();
                List<Integer[]> neighbours = getNegativeNeighbours(index, matrix);
                queue.addAll(neighbours);
            }
            passes++;
        }

        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[0].length; col++) {
                if(matrix[row][col] < 0) {
                    return -1;
                }
            }
        }

        // Write your code here.
        return passes - 1;
    }

    private List<Integer[]> getNegativeNeighbours(Integer[] index, int[][] matrix) {
        List<Integer[]> list = new ArrayList<>();
        int row = index[0];
        int col = index[1];
        if(row-1 >= 0 && matrix[row-1][col] < 0) {
            matrix[row-1][col] *= -1;
            list.add(new Integer[]{row-1, col});
        }
        if(col-1 >= 0 && matrix[row][col-1] < 0) {
            matrix[row][col-1] *= -1;
            list.add(new Integer[]{row, col-1});
        }
        if(row+1 < matrix.length && matrix[row+1][col] < 0) {
            matrix[row+1][col] *= -1;
            list.add(new Integer[]{row+1, col});
        }
        if(col+1 < matrix[0].length && matrix[row][col+1] < 0) {
            matrix[row][col+1] *= -1;
            list.add(new Integer[]{row, col+1});
        }
        return list;
    }
}
