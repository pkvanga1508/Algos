package trees;

//Make all left nodes as right and right nodes as left
public class InvertBinaryTree {

    public static void invertBinaryTree(BinaryTree tree) {
        if(tree == null) return;
        if(tree.left == null && tree.right == null) return; //Root Node cant do anything

        //Flip left and right nodes
        BinaryTree tmp = tree.left;
        tree.left = tree.right;
        tree.right = tmp;
        //Recursively call the function on the flipped nodes
        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);
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
