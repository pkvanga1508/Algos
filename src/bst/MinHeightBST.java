package bst;

import java.util.List;

//Given a Sorted Array, construct Min Height BST.
public class MinHeightBST {

    public static BST minHeightBst(List<Integer> array) {
        // Write your code here.
        return minHeightBst(0, array.size() - 1, array);
    }

    private static BST minHeightBst(int start, int end, List<Integer> array) {

        if(start > end) return null;
        if(start == end) return new BST(array.get(start));
        int mid = (start + end)/2;
        BST node = new BST(array.get(mid));
        node.left = minHeightBst(start, mid - 1, array);
        node.right = minHeightBst(mid + 1, end, array);
        return node;

    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }
}
