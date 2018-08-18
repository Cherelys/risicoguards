package sr.unasat.risicoguards.datastractures;

public class DistPar { // distance and parent
    public int distance; //distance from start to this vertex
    public int parentVert; //current parent of this vertex

    public DistPar(int pv, int d){ //constructor
        distance = d;
        parentVert = pv;
    }
}
