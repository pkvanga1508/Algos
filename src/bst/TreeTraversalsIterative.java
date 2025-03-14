package bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeTraversalsIterative {

    public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
        // Write your code here.
        List<Integer> nodes = new ArrayList<>();
        Stack<BST> stack = new Stack<>();
        BST node = tree;
        while(node != null || !stack.isEmpty()) {
            if(node != null) {
                stack.push(node); //We are trying to push the left nodes
                node = node.left; //Push the left
            } else { //Here we visited the left and we dont have anything more on left
                node = stack.pop();
                nodes.add(node.value);
                node = node.right;
            }
        }
        return nodes;
    }

    public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
        // Write your code here.
        List<Integer> values = new ArrayList<Integer>();
        Stack<BST> stack = new Stack<>();
        stack.push(tree);
        while(!stack.isEmpty()) {
            BST node = stack.pop();
            values.add(node.value);
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
        }
        return values;
    }

    public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {

        // Write your code here.
        return new ArrayList<Integer>();
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
