package bst;

//Given a Tree validate if its BST or not
public class ValidateBST {

    public static boolean validateBst(BST tree) {
        // Write your code here.
        return validateBst(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean validateBst(BST node, int minValue, int maxValue) {
        if(node == null) return true;
        if(node.value < minValue || node.value > maxValue) {
            return false;
        }
        return validateBst(node.left, minValue,  node.value - 1)
                && validateBst(node.right, node.value, maxValue);
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
