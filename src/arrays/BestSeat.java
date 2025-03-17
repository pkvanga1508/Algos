package arrays;

public class BestSeat {

    public int bestSeat(int[] seats) {

        int maxStartIndex = -1;
        int maxSize = 0;

        //Intermediate Empty seats
        int currStartIndex = -1;
        int currSize = 0;

        for(int index = 1; index < seats.length -1; index++) {
            if(seats[index] == 0) { //Seat is empty
                if(currSize == 0) {
                    currStartIndex = index;
                    currSize = 1;
                } else {
                    currSize++;
                }
                //Check if curre size > max size than max size is curr size.
                if(currSize > maxSize) {
                    maxSize = currSize;
                    maxStartIndex = currStartIndex;
                }
            } else { //Seat is not empty reset the curr size
                currSize = 0; //Reset Current size!
            }
        }

        // Write your code here.
        return maxStartIndex == -1 ? maxStartIndex : maxStartIndex + (maxSize - 1)/2;
    }
}
