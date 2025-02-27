package arrays;

public class TransposeMatrix {

    public int[][] transposeMatrix(int[][] matrix) {

        int[][] result = new int[matrix[0].length][matrix.length];
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[0].length; col++) {
                result[col][row] = matrix[row][col];
            }
        }
        // Write your code here.
        return result;
    }
}
