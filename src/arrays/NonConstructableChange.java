package arrays;

import java.util.Arrays;

//coins = [1,2,5]
//answer = 4
//coins = [5,7,1,1,2,3,22]
//answer = 20

public class NonConstructableChange {

    public int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins);
        int currentMaxChange = 0; //THis is the maximum change we can make using the coins
        // Write your code here.
        for(int value: coins) { //Keep processing the coins
            if(value > currentMaxChange + 1) { //we can not make change of currentMaxChange + 1 if value > currentMaxChange + 1
                return currentMaxChange + 1;
            } else {
                currentMaxChange += value;
            }
        }
        return currentMaxChange + 1;
    }
}
