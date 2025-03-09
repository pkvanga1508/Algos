package trees;

import java.util.Stack;

//Root all operands
//Other elements operations
// -1 add, -2 sub, -3 div -4 multplication
public class EvaluateExpressionTreeRecursive {

    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public int evaluateExpressionTree(BinaryTree tree) {

        Stack<BinaryTree> nodes = new Stack<>();
        Stack<Integer> numbers = new Stack<>();
        Stack<Integer> solution = new Stack<>();

        nodes.push(tree);
        while(!nodes.isEmpty()) {
            BinaryTree node = nodes.pop();
            numbers.push(node.value); //Push to numbers stack;
            //Push right first and left next as we need to perform operations -> left (op) right
            if(node.right != null) {
                nodes.push(node.right);
            }
            if(node.left != null) {
                nodes.push(node.left);
            }
        }

        while(!numbers.isEmpty()) {

            int number = numbers.pop();
            switch(number) {
                case -1:
                    solution.push(solution.pop() + solution.pop());
                    break;
                case -2:
                    solution.push(solution.pop() - solution.pop());
                    break;
                case -3:
                    solution.push(solution.pop() / solution.pop());
                    break;
                case -4:
                    solution.push(solution.pop() * solution.pop());
                    break;
                default:
                    solution.push(number);
            }
        }

        // Write your code here.
        return solution.pop();
    }
}
