package arrays;

//Go from begining to the see if the
// next value is incrementing, if its incrementing then add the current reward = 1 + revious reward
// next value is decrementing, then assign its value to 1 and see if you have to adjust the values before it
// For adjusting the value before it
// Loop till the begining od the array till you find the value before is more than the current value.
// Assign the reward to the previous value as Math.max(reward of previous value, reward of current value + 1)

public class MinRewardsNaiveApproach {

    public static int minRewards(int[] scores) {

        int[] rewards = new int[scores.length];
        int rewardCount = 0;
        rewards[0] = 1; //Base case

        for(int i = 1; i < scores.length; i++) {

            if(scores[i] > scores[i-1]) { //Scores are incrementing
                rewards[i] = rewards[i-1] + 1;
            } else { //Value is decrementing
                rewards[i] = 1; //Initialize the value to 1;
                int currIndex = i;
                while(currIndex > 0 &&
                        scores[currIndex -1] > scores[currIndex]) {
                    rewards[currIndex - 1] = Math.max(rewards[currIndex - 1], rewards[currIndex] + 1);
                    currIndex--;
                }
            }
        }

        for(int reward: rewards) {
            System.out.print(" " + reward);
            rewardCount += reward;
        }


        // Write your code here.
        return rewardCount;
    }
}
