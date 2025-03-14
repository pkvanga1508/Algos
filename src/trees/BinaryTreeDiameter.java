package trees;

public class BinaryTreeDiameter {

    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    int diameter = 0;
    public int binaryTreeDiameter(BinaryTree tree) {
        // Write your code here.
        diameterHelper(tree);
        return diameter;
    }

    private int diameterHelper(BinaryTree node) {
        if(node == null) return 0;
        int heightOfLeft = diameterHelper(node.left);
        int heightOfRight = diameterHelper(node.right);
        diameter = Math.max(diameter, heightOfLeft + heightOfRight);
        return 1 + Math.max(heightOfLeft, heightOfRight);
    }
}
