package dynamicprogramming;

public class NumberOfWaysToMakeChange {

    public static int numberOfWaysToMakeChange(int n, int[] denoms) {

        int[][] matrix = new int[denoms.length + 1][n+1];
        for(int i = 0; i < matrix.length; i++) {
            matrix[i][0] = 1;
        }
        for(int i = 1; i < matrix[0].length; i++) {
            matrix[0][i] = 0;
        }

        for(int row = 1; row < matrix.length; row++) {
            for(int col = 1; col < matrix[0].length; col++) {
                matrix[row][col] = matrix[row-1][col] +
                        ((col - denoms[row - 1]) >= 0 ? matrix[row][col - denoms[row - 1]] : 0);
            }
        }
        return matrix[matrix.length - 1][matrix[0].length - 1];
    }
}
