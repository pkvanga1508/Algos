package arrays;

import java.util.ArrayList;
import java.util.List;

//Find the valleys
//Assign rewards at valley as 1
//at each valley go the right untill value is incrementing and assign the reward as previous reward + 1
//at each valleu go to the left unitll value is incrementing and assign the reward as the formula
// Math.max(current reward, reward at next value + 1)
public class MinRewardsVallyAndPeaksApproach {

    public static int minRewards(int[] scores) {

        if(scores.length == 1) {
            return 1;
        }

        int[] rewards = new int[scores.length];
        int rewardCount = 0;
        //Find the vally indexes
        List<Integer> valleys = new ArrayList<>();
        if(scores[0] < scores[1]) valleys.add(0);
        if(scores[scores.length - 2]  > scores[scores.length - 1]) valleys.add(scores.length - 1);
        for(int i = 1; i < scores.length -1; i++) {
            if((scores[i - 1] > scores[i]) && (scores[i] < scores[i+1])) {
                valleys.add(i);
                rewards[i] = 1;
            }
        }

        for(int valley: valleys) {
            rewards[valley] = 1;
            int rightIndex = valley + 1;
            //Going right
            while((rightIndex < scores.length) && (scores[rightIndex] > scores[rightIndex - 1])) {
                rewards[rightIndex] = rewards[rightIndex - 1] + 1;
                rightIndex++;
            }
            int leftIndex = valley - 1;
            //Going left
            while((leftIndex >= 0) && (scores[leftIndex] > scores[leftIndex + 1])) {
                rewards[leftIndex] = Math.max(rewards[leftIndex], (rewards[leftIndex + 1] + 1));
                leftIndex--;
            }
        }

        for(int reward: rewards) {
            rewardCount += reward;
        }

        // Write your code here.
        return rewardCount;
    }
}
