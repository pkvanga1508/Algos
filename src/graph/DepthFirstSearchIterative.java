package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Use Stack insert the root (or first node)
//Loop until stack is not empty.
//Pop the element and add children to stack in reverse order (Order matters here)
//

public class DepthFirstSearchIterative {

    static class Node {

        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

//        Iterative solution
        public List<String> depthFirstSearch(List<String> array) {
           Stack<Node> stack = new Stack<>();
           stack.push(this);

           while(!stack.isEmpty()) {
             Node element = stack.pop();
             array.add(element.name);

             if(element.children != null) {
               for(int i = element.children.size() - 1; i >=0; i--) { //Put children in reverse order.
                 stack.push(element.children.get(i));
               }
             }
           }

           // Write your code here.
           return array;
         }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
