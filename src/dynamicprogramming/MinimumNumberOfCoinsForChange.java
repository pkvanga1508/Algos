package dynamicprogramming;

public class MinimumNumberOfCoinsForChange {
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {

        int[] memory = new int[n + 1];

        for(int i = 1; i < memory.length; i++) {
            int minValue = n + 1; //Large Value
            for(int denom: denoms) {
                if(denom <= i) {
                    minValue = Math.min(minValue, (memory[i - denom] + 1));
                }
            }
            memory[i] = minValue;
        }

        // Write your code here.
        return memory[n] == n + 1 ? -1 : memory[n]; //Not possible to make change
    }
}
