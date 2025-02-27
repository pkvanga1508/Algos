package graph;

//Here calculate the depth of each descendant and make sure descendant's are in same depth
//Then keep going to its Ancestor's and you will find a commom Ancestor that is youngest
public class YoungestCommonAncestor {

    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor,
            AncestralTree descendantOne,
            AncestralTree descendantTwo) {
        // Write your code here.
        int depthDescendentOne = getDepth(descendantOne);
        int depthDescendentTwo = getDepth(descendantTwo);

        //Make sure both of them are in same level.
        if(depthDescendentOne > depthDescendentTwo) {
            descendantOne = getNode(depthDescendentOne - depthDescendentTwo, descendantOne);
        } else {
            descendantTwo = getNode(depthDescendentTwo - depthDescendentOne, descendantTwo);
        }

        //Make sure both ancestors converge.
        while(descendantOne != descendantTwo) {
            descendantOne = descendantOne.ancestor;
            descendantTwo = descendantTwo.ancestor;
        }

        //Both descendantOne and descendantTwo meet at same ancestor
        return descendantOne;
    }

    private static int getDepth(AncestralTree tree) {
        int depth = 0;
        while(tree != null) {
            tree = tree.ancestor;
            depth++;
        }
        return depth++;
    }

    private static AncestralTree getNode(int depth, AncestralTree tree) {
        while(depth > 0) {
            tree = tree.ancestor;
            depth--;
        }
        return tree;
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }
}
