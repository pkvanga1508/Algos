package dynamicprogramming;

public class MaxSubsetNoAdjacentNumbers {

    public static int maxSubsetSumNoAdjacent(int[] array) {

        if(array.length == 0) return 0;
        if(array.length == 1) return array[0];
        int[] solution = new int[array.length];
        solution[0] = array[0];
        solution[1] = Math.max(array[0], array[1]);
        for(int i = 2; i < array.length; i++) {
            solution[i] = Math.max(solution[i-1], solution[i-2] + array[i]);
        }
        return solution[array.length - 1];
    }

    //Memory Optimization
    public static int maxSubsetSumNoAdjacentMemoryOptimization(int[] array) {

        if(array.length == 0) return 0;
        if(array.length == 1) return array[0];
        if(array.length == 2) return Math.max(array[0], array[1]);
        int[] memory = new int[3]; //2 Values + solution
        memory[0] = array[0];
        memory[1] = Math.max(array[0], array[1]);
        for(int i = 2; i < array.length; i++) {
            memory[2] = Math.max(memory[1], memory[0] + array[i]);
            memory[0] = memory[1]; //Reset the memory for next iteration
            memory[1] = memory[2];
        }
        return memory[2];
    }
}
