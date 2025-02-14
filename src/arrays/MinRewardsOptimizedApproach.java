package arrays;

//Fill the rewards with value 1
//Go from left to right and if the next value is increasing then assign the reward as previous reward + 1;
//Go from right to left and if the next value is increasing assign the reward using the formula
//Reward[index] = Math.max(reward[index], reward[index + 1] + 1)

import java.util.Arrays;

public class MinRewardsOptimizedApproach {

    public static int minRewards(int[] scores) {

        int[] rewards = new int[scores.length];
        int rewardCount = 0;
        Arrays.fill(rewards, 1); //Fill everything with 1

        //Go from left to right and if its increasing keep incremtning the reward
        for(int i = 1; i < scores.length; i++) {
            if(scores[i-1] < scores[i]) {
                rewards[i] = rewards[i-1] + 1;
            }
        }

        //Go from right to left and if its increasing increment the reward
        //Based on the formula
        for(int i = scores.length - 1; i > 0; i--) {
            if(scores[i] < scores[i-1]) {
                rewards[i-1] = Math.max(rewards[i-1], rewards[i] + 1);
            }
        }

        for(int reward: rewards) {
            rewardCount += reward;
        }

        // Write your code here.
        return rewardCount;
    }
}
