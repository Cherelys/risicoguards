package sr.unasat.risicoguards.algorithms;

import sr.unasat.risicoguards.datastractures.DistPar;
import sr.unasat.risicoguards.datastractures.Graph;

import static sr.unasat.risicoguards.datastractures.Graph.INFINITY;
import static sr.unasat.risicoguards.datastractures.Graph.MAX_VERTS;
import static sr.unasat.risicoguards.datastractures.Graph.NINFINITY;

public class Dijkstra {
    private Graph graph;
    private int currentVert; //current vertex
    private DistPar sPath[]; // array for shortest-path data
    private DistPar lPath[]; // array for longest-path data
    private int nTree;     // number of Verts in tree
    private int startToCurrent; //distance to currentVert

    public Dijkstra(Graph graph) {
        this.graph = graph;
        nTree = 0;
        sPath = new DistPar[MAX_VERTS];   // shortest paths
        lPath = new DistPar[MAX_VERTS];   // longests paths
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
            adjustsPathMin(); //update sPath[] array
        }

        displayShortestPaths(); // display sPath[] contents
        doClear(); //clear for next algorithm use
    }

    public void longestPath(){
        int startTree = 0;
        graph.getVertexList()[startTree].isInTree = true;
        nTree = 1;

        for (int j=0; j<graph.getnVerts(); j++){
            int tempDist = graph.getAdjMat()[startTree][j]; //set temp distance accordign to adjacency matrix
            tempDist = (tempDist == INFINITY) ? NINFINITY : tempDist;
            lPath[j]= new DistPar(startTree,tempDist); //create new distpar and put in sPath
        }

        //until all vertices are in the tree
        while (nTree < graph.getnVerts()){
            int indexMax= getMax(); // get maximum from lPath
            int maxDist = lPath[indexMax].distance;

            if (maxDist == NINFINITY){ //if all infinite or in tree
                System.out.println("there are unreachable vertices");
                break; //lPath is complete
            }else{
                currentVert = indexMax; //reset current vert to closest vert
                startToCurrent = lPath[indexMax].distance; //maximum distance from startTree is to currentVert, and is startToCurrent
            }

            //put current vertex in tree
            graph.getVertexList()[currentVert].isInTree = true;
            nTree++;
            adjustsPathMax(); //update sPath[] array
        }

        displayLongestPaths(); // display sPath[] contents
        doClear(); //clear for next algorithm use

    }



    private void doClear(){
        nTree = 0; //clear tree
        currentVert = 0; //clear currentVert
        startToCurrent = 0; //clear startToCurrent
        for (int j =0; j<graph.getnVerts(); j++) {
            graph.getVertexList()[j].isInTree = false;
        }
    }

    private int getMin(){
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

    private int getMax(){
        int maxDist = NINFINITY;
        int indexMax = 0;
        for(int j=1; j<graph.getnVerts(); j++) {
            //for each vertex, if it's in tree and bigger than old one
            if (!graph.getVertexList()[j].isInTree && lPath[j].distance > maxDist) {
                maxDist = lPath[j].distance;
                indexMax = j; //update minimum
            }
        }
        return indexMax; //return index of minimum
    }

    private void adjustsPathMin() {
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

    private void adjustsPathMax() {
        int column = 1;
        while (column < graph.getnVerts()) {

            //get distance from adjacency matrix
            int currentToFringe = graph.getAdjMat()[currentVert][column];

            //if column not adjacent skip
            if(currentToFringe == INFINITY){
                column++;
                continue;
            }

            //sum up the start to current and current to fringe distance
            int startToFringe = startToCurrent + currentToFringe;

            //get current lpath distance
            int lPathDist = lPath[column].distance;

            //if start to fringe larger swap distance and parent in distpar array
            if (startToFringe>lPathDist){
                lPath[column].parentVert = currentVert;
                lPath[column].distance = startToFringe;
            }
            column++;
        }
    }

    private void displayShortestPaths(){
        for (int j=0; j<graph.getnVerts(); j++){
            graph.displayVertex(0); //name[type]
            System.out.print( "->"); //name[type]->
            graph.displayVertex(j); //name[type]->name[type]
            System.out.print("="); //name[type]->name[type]=
            if (sPath[j].distance == INFINITY) {
                System.out.print("(inf"); //inf
            }else {
                System.out.print("(" + sPath[j].distance); //50
            }
            System.out.print("via ");
            graph.displayVertex(sPath[j].parentVert);
            System.out.print("), ");
        }
    }

    private void displayLongestPaths(){
        for (int j=0; j<graph.getnVerts(); j++){
            graph.displayVertex(0); //name[type]
            System.out.print( "->"); //name[type]->
            graph.displayVertex(j); //name[type]->name[type]
            System.out.print("="); //name[type]->name[type]=
            if (lPath[j].distance == NINFINITY) {
                System.out.print("(inf"); //inf
            }else {
                System.out.print("(" + lPath[j].distance); //50
            }
            System.out.print("via ");
            graph.displayVertex(sPath[j].parentVert);
            System.out.print("), ");
        }
    }

}
