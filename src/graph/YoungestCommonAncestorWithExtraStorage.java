package graph;

import java.util.HashSet;
import java.util.Set;

//Here calculate the depth of each descendant and make sure descendant's are in same depth
//Then keep going to its Ancestor's and you will find a commom Ancestor that is youngest
public class YoungestCommonAncestorWithExtraStorage {

    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor,
            AncestralTree descendantOne,
            AncestralTree descendantTwo
    ) {

        Set<AncestralTree> visited = new HashSet<>();
        //Introduce Set where we store AncestralTree that is visited
        while(descendantOne != null) {
            visited.add(descendantOne);
            descendantOne = descendantOne.ancestor;
        }

        while(descendantTwo != null) {
            if(visited.contains(descendantTwo)) return descendantTwo;
            descendantTwo = descendantTwo.ancestor;
        }

        return null; // Replace this line
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
