package lc.arrays;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if(m == 0) {
            for(int i = 0; i < n; i++) { //Manually copy all elements..
                nums1[i] = nums2[i];
            }
            return;
        }

        int index = m + n - 1;
        while(m > 0 && n > 0) {
            if(nums1[m - 1] <= nums2[n - 1]) {
                nums1[index] = nums2[n - 1];
                index--;
                n--;
            } else {
                nums1[index] = nums1[m - 1];
                nums1[m - 1] = 0;
                index--;
                m--;
            }
        }
        //If all the elements in the num1 are placed in right place and
        // some of the elements in nums2 are not processes because of m > 0 condition failure.
        while(n > 0) {
            nums1[index] = nums2[n - 1];
            index--;
            n--;
        }
    }
}
