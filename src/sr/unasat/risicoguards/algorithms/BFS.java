package sr.unasat.risicoguards.algorithms;

import sr.unasat.risicoguards.datastractures.Graph;
import sr.unasat.risicoguards.datastractures.Queue;

public class BFS {
    private Graph graph;
    private Queue queue;

    public BFS(Graph graph){
        this.graph = graph;
        this.queue = new Queue();
    }

    public void search(){
        graph.getVertexList()[0].wasVisited = true;
        graph.displayVertex(0);
        queue.insert(0);
        int v2;

        while(!queue.isEmpty()){ //until queue empty
            int v1 = queue.remove(); //remove vertex at head

            //unit it has no unvisited neigbours
            while( (v2 = graph.getAdjUnvisitedVertex(v1)) != -1){ //get one
                graph.getVertexList()[v2].wasVisited = true; //mark it
                graph.displayVertex(v2); //display it
                queue.insert(v2); //insert it
            }
        }

        //queue is empty, so we're done
        for(int j=0; j<graph.getnVerts(); j++){ //reset flags
            graph.getVertexList()[j].wasVisited = false;
        } //end bfs()
    }
}
