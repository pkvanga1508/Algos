package dynamicprogramming;

public class NumberOfWaysToTraverseGraph {

    public int numberOfWaysToTraverseGraph(int width, int height) {

        int[][] memory = new int[height][width];
        for(int i = 1; i < memory[0].length; i++) {
            memory[0][i] = 1;
        }
        for(int i = 1; i < memory.length; i++) {
            memory[i][0] = 1;
        }
        for(int row = 1; row < memory.length; row++) {
            for(int col = 1; col < memory[0].length; col++) {
                memory[row][col] = memory[row -1][col] + memory[row][col-1];
            }
        }
        // Write your code here.
        return memory[height - 1][width - 1];
    }
}
