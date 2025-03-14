package arrays;

public class ArrayOfProduct {

    public int[] arrayOfProducts(int[] array) {

        int[] product = new int[array.length];
        int[] leftProduct = new int[array.length];
        int[] rightProduct = new int[array.length];

        int leftProductVal = 1;
        for(int i = 0; i < array.length; i++) {
            leftProduct[i] = leftProductVal;
            leftProductVal = leftProductVal * array[i];
        }

        int rightProductVal = 1;
        for(int i = array.length - 1; i >= 0; i--) {
            rightProduct[i] = rightProductVal;
            rightProductVal = rightProductVal * array[i];
        }

        for(int i = 0; i < array.length; i++) {
            product[i] = leftProduct[i] * rightProduct[i];
        }

        // Write your code here.
        return product;
    }
}
