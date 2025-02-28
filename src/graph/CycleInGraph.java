package graph;

public class CycleInGraph {

    public boolean cycleInGraph(int[][] edges) {

        boolean[] visited = new boolean[edges.length];
        boolean[] inStack = new boolean[edges.length];

        for(int vertex = 0; vertex < edges.length; vertex++) {
            if(!visited[vertex]) {
                if(bfs(vertex, visited, inStack, edges)) {
                    return true;
                }
            }
        }
        // Write your code here.
        return false;
    }

    private boolean bfs(int vertex, boolean[] visited,
                        boolean[] inStack, int[][] edges) {

        if(inStack[vertex]) return true; //If the vertex is in the stack (Back vertex)
        if(visited[vertex]) return false; //If its already visited return false;
        visited[vertex] = inStack[vertex] = true; //Mark both visited and inStack = true
        for(int neighbouringNode : edges[vertex]) {
            //If any of the neighbouring node has (back vertex) - return true.
            if(bfs(neighbouringNode, visited, inStack, edges)) {
                return true;
            }
        }
        inStack[vertex] = false; //This point we finished processing of the node;
        return false; //return false as we did not have a back vertex
    }
}
