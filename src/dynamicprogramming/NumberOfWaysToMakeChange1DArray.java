package dynamicprogramming;

public class NumberOfWaysToMakeChange1DArray {

    public static int numberOfWaysToMakeChange(int n, int[] denoms) {

        int[] memory = new int[n + 1];
        memory[0] = 1; //Base case
        for(int denom : denoms) {
            for(int i = 1; i < memory.length; i++) {
                if(i >= denom) {
                    memory[i] = memory[i] + memory[i - denom];
                }
            }
        }

        // Write your code here.
        return memory[n];
    }
}
