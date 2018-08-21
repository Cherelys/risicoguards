package sr.unasat.risicoguards.app;

import sr.unasat.risicoguards.algorithms.BFS;
import sr.unasat.risicoguards.algorithms.DFS;
import sr.unasat.risicoguards.algorithms.Dijkstra;
import sr.unasat.risicoguards.datastractures.Graph;

public class App {
    public static void main(String[] args) {

        //Een security bedrijf heeft een daling gemerkt in het aantal bedrijven dat guards bij hun huurt.
        // Na onderzoek blijkt dat dit is omdat ze meestal de verkeerde guards plaatsen bij bedrijven, posten of shifts.
        //Zij willen daarom een systeem waarbij er automatisch aan de hand van de skillset van de guard
        // de meest efficiënte shift van een post bij het juiste bedrijf gekozen wordt.


        //Zij moeten dus bedrijven kunnen toevoegen met een bepaalde waarde,
        // aan de bedrijven moeten zij ook posten kunnen toevoegen met een bepaalde waarde
        // en ook moeten zij aan de posten ook shifts kunnen toevoegen met een bepaalde waarde.
        // De waarde zal aan de hand van de risico hoog of laag zijn (0-10).
        Graph graph = new Graph();
        graph.generate();


        BFS bfs = new BFS(graph);
        DFS dfs = new DFS(graph);

        //Zij moeten een overzicht krijgen van alle bedrijven
        //bfs.displayAllCompanies();

        //of enkel,
        //dfs.displayCompany("Yin Long");

        // een overzicht van alle posten
        //bfs.displayAllPosts();

        // of per gekozen bedrijf,
        //dfs.displayPosts("Rosebel");

        // en een overzicht van alle shifts
        //bfs.displayAllShifts();

        // of enkel van een post die natuurlijk is aangesloten bij een bedrijf.
        //dfs.displayShifts("Productie");


        //4. dijkstra kort
//        System.out.print("Dijkstra kort: ");
//        Dijkstra dijkstra = new Dijkstra(graph);
//        dijkstra.shortestPath();
//        System.out.println();
//
//        //5. dijkstra lang
//        System.out.print("Dijkstra lang: ");
//        dijkstra.longestPath();
//        System.out.println();
    }
}
