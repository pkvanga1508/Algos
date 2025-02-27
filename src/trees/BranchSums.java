package trees;

import java.util.ArrayList;
import java.util.List;

//Input Tree
//                   1
//              2           3
//         4        5    6       7
//
//    8      9   10

// Output [15,16,18,10,11]

public class BranchSums {

    // This is the class of the input root. Do not edit it.
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {
        // Write your code here.
        List<Integer> branchSumList = new ArrayList<>();
        branchSums(root, 0, branchSumList);
        return branchSumList;

    }

    public static void branchSums(BinaryTree node, int sum, List<Integer> branchSums) {

        if(node.left == null && node.right == null) {
            branchSums.add(node.value + sum);
            return;
        }
        if(node.left != null) {
            branchSums(node.left, node.value + sum, branchSums);
        }
        if(node.right != null) {
            branchSums(node.right, node.value + sum, branchSums);
        }
    }
}
