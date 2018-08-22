package sr.unasat.risicoguards.app;

import sr.unasat.risicoguards.algorithms.BFS;
import sr.unasat.risicoguards.algorithms.DFS;
import sr.unasat.risicoguards.algorithms.Dijkstra;
import sr.unasat.risicoguards.datastractures.Graph;
import sr.unasat.risicoguards.datastractures.Guard;
import sr.unasat.risicoguards.datastractures.PriorityQ;

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

        //Zij moeten aan de hand van gegeven guards
        PriorityQ guardsQueue = new PriorityQ(20);

        guardsQueue.insert(new Guard("Don Pro", 96));
        guardsQueue.insert(new Guard("Al Rookie", 27));
        guardsQueue.insert(new Guard("Tony Intermediate", 54));
        guardsQueue.insert(new Guard("Maartin Narain", 85));
        guardsQueue.insert(new Guard("Anthony Main", 48));
        guardsQueue.insert(new Guard("Kevin Leeflang", 72));
        guardsQueue.insert(new Guard("Donovan Altenberg", 63));
        guardsQueue.insert(new Guard("Mitchell Fransman", 84));
        guardsQueue.insert(new Guard("Kenneth Djoe", 58));
        guardsQueue.insert(new Guard("Peter Waakman", 37));
        guardsQueue.insert(new Guard("Walter Korte", 77));
        guardsQueue.insert(new Guard("Eztra Kabouter", 49));


        Dijkstra dijkstra = new Dijkstra(graph);

        // een overzicht krijgen van de locaties waar de guards zijn geplaatst
        // (dit met ongeveer dezelfde bovengenoemde overzicht methodes).
        //dijkstra.placeGuards(guardsQueue);

        //Zij moeten ook heel makkelijk de goedkoopste of de duurste shift, post of bedrijf kunnen vinden.

        //goedkoopste shift
        dijkstra.cheapestShift();

        //goedkoopste post

        //goedkoopste bedrijf

        //duurste shift

        //duurste post

        //duurste bedrijf
    }
}
