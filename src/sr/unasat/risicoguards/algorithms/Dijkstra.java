package sr.unasat.risicoguards.algorithms;

import sr.unasat.risicoguards.datastractures.DistPar;
import sr.unasat.risicoguards.datastractures.Graph;

import static sr.unasat.risicoguards.datastractures.Graph.INFINITY;

public class Dijkstra {
    private Graph graph;
    private int currentVert; //current vertex
    private DistPar sPath[]; // array for shortest-path data
    private int nTree;     // number of Verts in tree
    private int startToCurrent; //distance to currentVert

    public Dijkstra(Graph graph) {
        this.graph = graph;
        nTree = 0;
        sPath = new DistPar[Graph.MAX_VERTS];   // shortest paths
    }

    public void shortestPath(){  //find all shortes path
        int startTree = 0;     // start at vertex 0
        graph.getVertexList()[startTree].isInTree = true;
        nTree = 1; //put in tree

        // transfer row of distances from adjmat to spath
        for (int j=0; j<graph.getnVerts(); j++){
            int tempDist = graph.getAdjMat()[startTree][j];
            sPath[j]= new DistPar(startTree,tempDist);
        }

        //until all vertices are in the tree
        while (nTree < graph.getnVerts()){
            int indexMin= getMin(); // get minimum from sPath
            int minDist = sPath[indexMin].distance;

            if (minDist== INFINITY){ //if all infinite or in tree
                System.out.println("there are unreachable vertices");
                break; //sPath is complete
            }else{
                currentVert = indexMin; //reset current vert to closest vert
                startToCurrent = sPath[indexMin].distance; //minimum distance from startTree is to currentVert, and is startToCurrent
            }

            //put current vertex in tree
            graph.getVertexList()[currentVert].isInTree = true;
            nTree++;
            adjust_spath(); //update sPath[] array
        }

        displayPaths(); // display sPath[] contents

        nTree = 0; //clear tree
        for (int j =0; j<graph.getnVerts(); j++) {
            graph.getVertexList()[j].isInTree = false;
        }
    }

    public int getMin(){
        int minDist = INFINITY; //get entry from sPath with minimum distance assume minimum
        int indexMin = 0;
        for(int j=1; j<graph.getnVerts(); j++) {
            //for each vertex, if it's in tree and smaller than old one
            if (!graph.getVertexList()[j].isInTree && sPath[j].distance < minDist) {
                minDist = sPath[j].distance;
                indexMin = j; //update minimum
            }
        }
        return indexMin; //return index of minimum
    }

    public void adjust_spath() {
        //adjust values in shortest-path array sPath
        int column = 1; //skip starting vertex
        while (column < graph.getnVerts()) { //go across columns

            //if this column's vertex already in tree, skip it
            if (graph.getVertexList()[column].isInTree){
                column++;
                continue;
            }

            //calculate distance for one sPath entry

            // get edge from currentVert to column
            int currentToFringe = graph.getAdjMat()[currentVert][column];

            // add distance from start
            int startToFringe = startToCurrent + currentToFringe;

            // get distance of current sPath entry
            int sPathDist = sPath[column].distance;

            // compare distance from start with sPath entry
            if (startToFringe<sPathDist){
                //if shorter, update sPath
                sPath[column].parentVert = currentVert;
                sPath[column].distance = startToFringe;
            }
            column++;
        }
    }

    public void displayPaths(){
        System.out.print("[");
        for (int j=0; j<graph.getnVerts(); j++){
            System.out.print(graph.getVertexList()[j].label+ "=");
            if (sPath[j].distance == INFINITY) {
                System.out.print("inf,");
            }else {
                System.out.print(sPath[j].distance + ",");
            }
            char parent = graph.getVertexList()[sPath[j].parentVert].label;
            System.out.print("("+ parent +")");
        }
        System.out.println("]");
    }

}
