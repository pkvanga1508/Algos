package arrays;

public class ArrayOfProductOptimization {

    public int[] arrayOfProducts(int[] array) {

        int[] product = new int[array.length];
        int[] leftProduct = new int[array.length];

        int leftProductVal = 1;
        for(int i = 0; i < array.length; i++) {
            leftProduct[i] = leftProductVal;
            leftProductVal *= array[i];
        }

        int rightProductVal = 1;
        for(int i = array.length - 1; i >= 0; i--) {
            leftProduct[i] *= rightProductVal;
            rightProductVal *= array[i];
        }

        // Write your code here.
        return leftProduct;
    }
}
