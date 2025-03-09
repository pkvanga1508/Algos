package graph;

import java.util.Stack;

//input Connect graph
//check if nodes can be given 2 colors and no two adjacent nodes can have same color
public class TwoColorGraph {

    public boolean twoColorable(int[][] edges) {

        //0, 1 -> 2 colors
        Integer[] colors = new Integer[edges.length];
        Stack<Integer> stack = new Stack<>(); //We are doing DFS to visit all nodes.
        stack.push(0); //Push first vertex in stack
        colors[0] = 0; //Assign first vertex as color 0

        while(!stack.isEmpty()) {
            int edge = stack.pop();
            for(int neighbouringEdge : edges[edge]) {
                if(colors[neighbouringEdge] == colors[edge]) return false;
                if(colors[neighbouringEdge] == null) {
                    colors[neighbouringEdge] = colors[edge] == 0 ? 1 : 0;
                    stack.push(neighbouringEdge);
                }
            }
        }
        return true;
    }
}
