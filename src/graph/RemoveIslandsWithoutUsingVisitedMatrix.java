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
//all the 1's that are connected to 1st row, 1st col, last row, last col are marked as 2
//Loop again and replace 2's by 1 and remaining 1's by 0's.
//Same as other solution instead of using visited array use 2's.
public class RemoveIslandsWithoutUsingVisitedMatrix {

    public int[][] removeIslands(int[][] matrix) {

        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[0].length; col++) {
                //First row, last row, first column, last column
                if(row == 0 || row == matrix.length - 1
                        || col == 0 || col == matrix[0].length - 1) {
                    if(matrix[row][col] == 1) {
                        process(row, col, matrix);
                    }
                }
            }
        }

        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[0].length; col++) {
                if(matrix[row][col] == 1) {
                    matrix[row][col] = 0;
                }
                if(matrix[row][col] == 2) {
                    matrix[row][col] = 1;
                }
            }
        }
        // Write your code here.
        return matrix;
    }

    private static void process(int row, int col, int[][] matrix) {

        if(row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) return;
        //If the value == 0 or value == 2 (already visited)
        if(matrix[row][col] == 0 || matrix[row][col] == 2) return;
        matrix[row][col] = 2;
        process(row-1, col, matrix);
        process(row+1, col, matrix);
        process(row, col-1, matrix);
        process(row, col+1, matrix);
    }
}
