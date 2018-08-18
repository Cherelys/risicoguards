package sr.unasat.risicoguards.algorithms;

import sr.unasat.risicoguards.datastractures.Graph;
import sr.unasat.risicoguards.datastractures.Stack;

public class DFS {
    private Graph graph;
    private Stack stack;

    public DFS(Graph graph){
        this.graph = graph;
        this.stack = new Stack();
    }

    public void search(){ //depth-first search
        graph.getVertexList()[0].wasVisited = true; //begin at vertex 0, mark it
        graph.displayVertex(0); // display it
        stack.push(0); // push it

        while (!stack.isEmpty()){ //until stack is empty
            //get an unvisited vertex adjacent to stack top
            int v = graph.getAdjUnvisitedVertex(stack.peek());
            if(v == -1) { //if no such vertex
                stack.pop();
            }else{ //if it exists
                graph.getVertexList()[v].wasVisited = true; //mark it
                graph.displayVertex(v); //display it
                stack.push(v); //push it
            }
        } //end while

        //stack is empty, so we're done
        for(int j=0; j<graph.getnVerts(); j++){
            graph.getVertexList()[j].wasVisited = false;
        } //end dfs
    }
}
