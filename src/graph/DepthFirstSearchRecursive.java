package graph;

import java.util.ArrayList;
import java.util.List;

//Call Depth first search on the root
//If the root has children keep calling the depth first search on children.
public class DepthFirstSearchRecursive {

    static class Node {

        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        //Recursive solution
        public List<String> depthFirstSearch(List<String> array) {
            depthFirstSearch(this, array);
            return array;
        }

        //Recursive solution
        public void depthFirstSearch(Node node, List<String> array) {
            array.add(node.name);
            for(Node child: node.children) {
                depthFirstSearch(child, array);
            }
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
