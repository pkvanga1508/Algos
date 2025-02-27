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

public class RiverSizes {

    public static List<Integer> riverSizes(int[][] matrix) {

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        List<Integer> riverLengths = new ArrayList<>();
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[0].length; col++) {
                if(visited[row][col] || matrix[row][col] == 0) continue;
                process(row, col, matrix, visited, riverLengths);
            }
        }
        return riverLengths;
        // Write your code here.
    }

    private static void process(int row, int col,
                                int[][] matrix, boolean[][] visited,
                                List<Integer> riverLengths) {

        //THis is the point where row, col is not visited
        //And there is 1 in arr[row][col]
        int currLength = 0;
        Stack<Idx> stack = new Stack<>();
        visited[row][col] = true;
        Idx currIdx = new Idx(row, col);
        stack.push(currIdx);
        while(!stack.isEmpty()) {
            currIdx = stack.pop();
            currLength++;
            List<Idx> neighbours = getNeighbours(currIdx, matrix, visited);
            for(Idx neighbour : neighbours) {
                stack.push(neighbour);
            }
        }
        riverLengths.add(currLength);
    }

    private static List<Idx> getNeighbours(Idx currIdx,
                                           int[][] matrix,
                                           boolean[][] visited) {

        List<Idx> neighbours = new ArrayList<>();
        int row = currIdx.row;
        int col = currIdx.col;
        if(row - 1 > 0 && !visited[row-1][col]) {
            visited[row-1][col] = true; //Visit the node
            if(matrix[row-1][col] == 1) { //Put in neighbour that we want to do DFS
                neighbours.add(new Idx(row-1, col));
            }
        }
        if(col - 1 > 0 && !visited[row][col-1]) {
            visited[row][col-1] = true; //Visit the node
            if(matrix[row][col-1] == 1) { //Put in neighbour that we want to do DFS
                neighbours.add(new Idx(row, col-1));
            }
        }

        if(row + 1 < matrix.length && !visited[row+1][col]) {
            visited[row+1][col] = true; //Visit the node
            if(matrix[row+1][col] == 1) { //Put in neighbour that we want to do DFS
                neighbours.add(new Idx(row+1, col));
            }
        }

        if(col + 1 < matrix[0].length && !visited[row][col+1]) {
            visited[row][col+1] = true; //Visit the node
            if(matrix[row][col+1] == 1) { //Put in neighbour that we want to do DFS
                neighbours.add(new Idx(row, col+1));
            }
        }

        return neighbours;
    }

    private static class Idx {
        int row;
        int col;
        public Idx(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
