package trees;

import java.util.Stack;

//Make all left nodes as right and right nodes as left
public class InvertBinaryTreeIterative {

    public static void invertBinaryTree(BinaryTree tree) {

        Stack<BinaryTree> stack = new Stack<>();
        stack.push(tree);
        while(!stack.isEmpty()) {
            BinaryTree node = stack.pop();
            if(node.left != null) {
                stack.push(node.left);
            }
            if(node.right != null) {
                stack.push(node.right);
            }
            swap(node);
        }
        // Write your code here.
    }

    private static void swap(BinaryTree node) {

        BinaryTree tmp = node.left;
        node.left = node.right;
        node.right = tmp;
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

}
