package trees;

//distance between a node and its root is depth.
//calculate sum of all depths of tree
public class Nodedepths {

    public static int nodeDepths(BinaryTree root) {

        return nodeDepths(root, 0);
    }

    private static int nodeDepths(BinaryTree node, int depth) {
        if(node == null) return 0;
        depth += nodeDepths(node.left, depth+1) //Every level we increment the depth by 1
                + nodeDepths(node.right, depth+1); //Depth of right subtree
        return depth;
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
