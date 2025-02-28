package graph;

public class CycleInGraphUsingWhiteGreyBlack {

    int white = 0; // UnVisited
    int grey = 1;  // Visited and in stack
    int black = 2; // Finished Processing

    public boolean cycleInGraph(int[][] edges) {

        int[] vertexStatus = new int[edges.length]; //All vertex's start with 0 -> Unvisited

        for(int vertex = 0; vertex < edges.length; vertex++) {
            if(vertexStatus[vertex] == 0) {
                if(bfs(vertex, vertexStatus, edges)) {
                    return true;
                }
            }
        }
        // Write your code here.
        return false;
    }

    private boolean bfs(int vertex, int[] vertexStatus, int[][] edges) {

        if(vertexStatus[vertex] == 1) return true; //If the vertex is in the stack (Back vertex)
        if(vertexStatus[vertex] == 2) return false; //If its already processed return false;
        vertexStatus[vertex] = 1; //Mark the vertex as in Stack
        for(int neighbouringNode : edges[vertex]) {
            //If any of the neighbouring node has Cycle then return true
            if(bfs(neighbouringNode, vertexStatus, edges)) {
                return true;
            }
        }
        vertexStatus[vertex] = 2; //Vertex finished processing
        return false; //return false
    }
}
