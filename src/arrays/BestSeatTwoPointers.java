package arrays;

public class BestSeatTwoPointers {

    public int bestSeat(int[] seats) {

        int left = 0;
        int right = 0;
        int maxLength = 0;
        int fevPosition = -1;
        // Write your code here.
        while(left < seats.length) {

            if(seats[left] == 1) {
                left++;
                continue;
            }

            right = left + 1;
            while(seats[right] == 0) {
                right++;  //keep going right
            }
            int currLength = right - left + 1;
            if(currLength > maxLength) {
                maxLength = currLength;
                fevPosition = left + (right - left - 1)/2;
                System.out.println("fevPosition " + fevPosition);
            }
            left = right;
        }
        return fevPosition;
    }
}
