package sr.unasat.risicoguards.datastractures;

public class Graph {
    public static final int MAX_VERTS = 25;
    public static final int INFINITY = 1000000;
    public static final int NINFINITY = -1000000;
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

    public void addVertex(String name, String type){ //argument is label
        vertexList[nVerts++] =  new Vertex(name, type);
    }

    public void addEdge(int start, int end, int risk){
        adjMat[start][end] = risk;

        //only if undirected graph
        //adjMat[end][start] = weight;
    }

    public void displayVertex(int v){
        System.out.print(vertexList[v].name + "[" + vertexList[v].type + "]");
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

    public void generate(){
        //Root
        this.addVertex("Risicoguards", "root"); //0 risicoguards-root

        //Rosebel
        this.addVertex("Rosebel", "company"); //1 rosebel-company
        this.addVertex("Poort", "post"); //2 rosebel-company, poort-post
        this.addVertex("Mine", "post"); //3 rosebel-company, mine-post
        this.addVertex("Poort-Dag", "shift"); //4 rosebel-company, poort-post, dag-shift
        this.addVertex("Poort-Nacht", "shift"); //5 rosebel-company, poort-post, nacht-shift
        this.addVertex("Mine-Dag", "shift"); //6 rosebel-company, mine-post, dag-shift
        this.addVertex("Mine-Nacht", "shift"); //7 rosebel-company, mine-post, nacht-shift

        //Kuldipsingh
        this.addVertex("Kuldipsingh", "company"); //8 kuldipsingh-company
        this.addVertex("Ingang", "post"); //9 kuldipsingh-company, ingang-post
        this.addVertex("Productie", "post"); //10 kuldipsingh-company, productie-post
        this.addVertex("Ingang-Dag", "shift"); //11 kuldipsingh-company, ingang-post, dag-shift
        this.addVertex("Ingang-Nacht", "shift"); //12 kuldipsingh-company, ingang-post, nacht-shift
        this.addVertex("Productie-Dag", "shift"); //13 kuldipsingh-company, productie-post, dag-shift
        this.addVertex("Productie-Nacht", "shift"); //14 kuldipsingh-company, productie-post, nacht-shift

        //Yin Long
        this.addVertex("Yin Long", "company"); //15 yinlong-company
        this.addVertex("Kassa", "post"); //16 yinlong-company, kassa-post
        this.addVertex("Rekken", "post"); //17 yinlong-company, rekken-post
        this.addVertex("Kassa-Dag", "shift"); //18 yinlong-company, kassa-post, dag-shift
        this.addVertex("Kassa-Nacht", "shift"); //19 yinlong-company, kassa-post, nacht-shift
        this.addVertex("Rekken-Dag", "shift"); //20 yinlong-company, rekken-post, dag-shift

        //Root to companies
        this.addEdge(0,1,8); //Root->Rosebel
        this.addEdge(0,8,5); //Root->Kuldipsingh
        this.addEdge(0,15,2); //Root->Yin Long

        //Companies to posts
        this.addEdge(1,2,5); //Rosebel->Poort
        this.addEdge(1,3,8); //Rosebel->Mine
        this.addEdge(8,9,6); //Kuldipsingh->Poort
        this.addEdge(8,10,3); //Kuldipsingh->Productie
        this.addEdge(15,16,8); //YinLong->Kassa
        this.addEdge(15,17,5); //YinLong->Rekken

        //Posts to shifts
        this.addEdge(2,4,3); //(Rosebel)Poort->Dag
        this.addEdge(2,5,6); //(Rosebel)Poort->Nacht
        this.addEdge(3,6,4); //(Rosebel)Mine->Dag
        this.addEdge(3,7,8); //(Rosebel)Mine->Nacht
        this.addEdge(9,11,4); //(Kuldipsingh)Poort->Dag
        this.addEdge(9,12,6); //(Kuldipsingh)Poort->Nacht
        this.addEdge(10,13,4); //(Kuldipsingh)Productie->Dag
        this.addEdge(10,14,5); //(Kuldipsingh)Productie->Nacht
        this.addEdge(16,18,5); //(YinLong)Kassa->Dag
        this.addEdge(16,19,8); //(YinLong)Kassa->Nacht
        this.addEdge(17,20,4); //(YinLong)Rekken->Dag
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
