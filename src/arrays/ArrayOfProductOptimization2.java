package arrays;

public class ArrayOfProductOptimization2 {

    public int[] productExceptSelf(int[] nums) {
        int[] product = new int[nums.length];
        product[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            product[i] = product[i - 1] * nums[i - 1];
        }
        int rightProduct = 1;
        for(int i = nums.length - 2; i >= 0; i--) {
            rightProduct = rightProduct * nums[i + 1];
            product[i] = product[i] * rightProduct;
        }
        return product;
    }
}
