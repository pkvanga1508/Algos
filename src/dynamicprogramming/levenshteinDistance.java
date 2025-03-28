package dynamicprogramming;

public class levenshteinDistance {

    public static int levenshteinDistance(String str1, String str2) {

        int[][] memory = new int[str1.length() + 1][str2.length() + 1];
        for(int i = 1; i < memory[0].length; i++) { //Fill the first row
            memory[0][i] = i;
        }
        for(int i = 1; i < memory.length; i++) { //Fill the first column
            memory[i][0] = i;
        }

        for(int row = 1; row < memory.length; row++) {
            for(int col = 1; col < memory[0].length; col++) {
                if(str1.charAt(row - 1) == str2.charAt(col -1)) {
                    memory[row][col] = memory[row -1][col -1];
                } else {
                    memory[row][col] = 1+ Math.min(Math.min(memory[row -1][col-1], memory[row -1][col]), memory[row][col - 1]);
                }
            }
        }

        // Write your code here.
        return memory[str1.length()][str2.length()];
    }
}
