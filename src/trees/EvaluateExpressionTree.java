package trees;

//Root all operands
//Other elements operations
// -1 add, -2 sub, -3 div -4 multplication
public class EvaluateExpressionTree {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public int evaluateExpressionTree(BinaryTree tree) {

        if(tree.left == null && tree.right == null) return tree.value; //Leaf node
        switch(tree.value) {
            case -1 :
                return evaluateExpressionTree(tree.left) + evaluateExpressionTree(tree.right);
            case -2 :
                return evaluateExpressionTree(tree.left) - evaluateExpressionTree(tree.right);
            case -3 :
                return evaluateExpressionTree(tree.left) / evaluateExpressionTree(tree.right);
            case -4 :
                return evaluateExpressionTree(tree.left) * evaluateExpressionTree(tree.right);
            default:
                return tree.value;
        }
    }
}
