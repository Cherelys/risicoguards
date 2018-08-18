package sr.unasat.risicoguards.datastractures;

public class Graph {
    public static final int MAX_VERTS = 20;
    public static final int INFINITY = 1000000;
    private Vertex vertexList[]; //array of vertices
    private int adjMat[][]; //adjacency matrix
    private int nVerts; //current number of vertices

    public Graph(){ //constructor
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int j = 0; j < MAX_VERTS; j++){ //set adjecency
            for (int k = 0; k < MAX_VERTS; k++) {   // matrix
                adjMat[j][k] = INFINITY;    //to INFINITY
            }
        }
    }

    public void addVertex(char label){ //argument is label
        vertexList[nVerts++] =  new Vertex(label);
    }

    public void addEdge(int start, int end, int weight){
        adjMat[start][end] = weight;
        adjMat[end][start] = weight;
    }

    public void displayVertex(int v){
        System.out.print(vertexList[v].label);
    }

    //return an unvisited vertex adj to v
    public int getAdjUnvisitedVertex(int v){
        for(int j=0; j<nVerts; j++){
            if(adjMat[v][j] != INFINITY && vertexList[j].wasVisited == false){
                return j;
            }
        }
        return -1;
    }

    public Vertex[] getVertexList() {
        return vertexList;
    }

    public int getnVerts() {
        return nVerts;
    }

    public int[][] getAdjMat() {
        return adjMat;
    }



} //end class Graph
