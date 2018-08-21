package sr.unasat.risicoguards.app;

import sr.unasat.risicoguards.algorithms.BFS;
import sr.unasat.risicoguards.algorithms.DFS;
import sr.unasat.risicoguards.algorithms.Dijkstra;
import sr.unasat.risicoguards.datastractures.Graph;

public class App {
    public static void main(String[] args) {

        //1. create graph
        Graph graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');

        graph.addEdge(0,1,1); //AB
        graph.addEdge(0,3,6); //AD
        graph.addEdge(1,2,5); //BC
        graph.addEdge(3,4,4); //DE
        graph.addEdge(3,5,2); //DF
        graph.addEdge(4,6,3); //EG
        graph.addEdge(5,6,9); //FG

        //2. bfs searches
        System.out.print("BFS Visits: ");
        BFS bfs = new BFS(graph);
        bfs.search();
        System.out.println();

        //3. dfs searches
        System.out.print("DFS Visits: ");
        DFS dfs = new DFS(graph);
        dfs.search();
        System.out.println();

        //4. dijkstra kort
        System.out.print("Dijkstra kort: ");
        Dijkstra dijkstra = new Dijkstra(graph);
        dijkstra.shortestPath();
        System.out.println();

        //5. dijkstra lang
        System.out.print("Dijkstra lang: ");
        dijkstra.longestPath();
        System.out.println();
    }
}
