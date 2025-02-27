package graph;

//input
//
//[
//        [1, 0, 0, 0, 0, 0],
//        [0, 1, 0, 1, 1, 1],
//        [0, 0, 1, 0, 1, 0],
//        [1, 1, 0, 0, 1, 0],
//        [1, 0, 1, 1, 0, 0],
//        [1, 0, 0, 0, 0, 1]
//        ]

//output:
//        [
//        [1, 0, 0, 0, 0, 0],
//        [0, 0, 0, 1, 1, 1],
//        [0, 0, 0, 0, 1, 0],
//        [1, 1, 0, 0, 1, 0],
//        [1, 0, 0, 0, 0, 0],
//        [1, 0, 0, 0, 0, 1]
//        ]

//Island is value 1 that is not connected to the first row, first col, last row, last col
public class RemoveIslands {

    public int[][] removeIslands(int[][] matrix) {

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[0].length; col++) {
                //First row, last row, first column, last column
                if(row == 0 || row == matrix.length - 1
                        || col == 0 || col == matrix[0].length - 1) {
                    if(matrix[row][col] == 1) {
                        process(row, col, matrix, visited);
                    }
                }
            }
        }

        for(int row = 1; row < matrix.length -1 ; row++) {
            for(int col = 1; col < matrix[0].length -1; col++) {
                if(matrix[row][col] == 1 && !visited[row][col]) {
                    matrix[row][col] = 0;
                }
            }
        }
        // Write your code here.
        return matrix;
    }

    private static void process(int row, int col, int[][] matrix, boolean[][] visited) {

        if(row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) return;
        if(matrix[row][col] == 0 || visited[row][col]) return;
        visited[row][col] = true;
        System.out.println("row: " + row + " col: " + col);
        process(row-1, col, matrix, visited);
        process(row+1, col, matrix, visited);
        process(row, col-1, matrix, visited);
        process(row, col+1, matrix, visited);
    }
}
