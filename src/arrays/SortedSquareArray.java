package arrays;

//input [1,2,3,4,5,6,7]
//output [1,4,9,16,25,36,49]

//imput [-5,-3,0,2,4,6]
//output [0,4,9,16,25,36]

//The issue happens if there are negative values
//Start with 2 pointers start and end
//compare the abs value of start and end index and see which is large
//Put the largest values at the end of the array
//Increment or decrement pointers based on that.
public class SortedSquareArray {

    public int[] sortedSquaredArray(int[] array) {

        int[] result = new int[array.length];
        int start = 0;
        int end = array.length - 1;
        int counter = array.length - 1;
        while(start <= end) {
            if(Math.abs(array[start]) >= Math.abs(array[end])) {
                result[counter--] = array[start] * array[start];
                start++;
            } else {
                result[counter--] = array[end] * array[end];
                end--;
            }
        }
        // Write your code here.
        return result;
    }
}
