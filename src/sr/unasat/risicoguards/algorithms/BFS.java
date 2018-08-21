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

    public void displayAllCompanies() {
        System.out.println("Alle bedrijven: ");

        graph.getVertexList()[0].wasVisited = true; //start with root
        queue.insert(0);
        int v2;

        while(!queue.isEmpty()){ //until queue empty
            int v1 = queue.remove(); //remove vertex at head

            //unit it has no unvisited neigbours
            while( (v2 = graph.getAdjUnvisitedVertex(v1)) != -1){ //get one
                graph.getVertexList()[v2].wasVisited = true; //mark it

                if(graph.getVertexList()[v2].type == "company"){
                    System.out.print("- ");
                    graph.displayVertex(v2); //if of type company display it
                    System.out.println();
                }

                if(graph.getVertexList()[v2].type == "post"){
                    break; //if of type post it means no companies left so break
                }

                queue.insert(v2); //insert it
            }
        }

        //queue is empty, so we're done
        for(int j=0; j<graph.getnVerts(); j++){ //reset flags
            graph.getVertexList()[j].wasVisited = false;
        }
    }

    public void displayAllPosts() {
        System.out.println("Alle posten: ");

        graph.getVertexList()[0].wasVisited = true; //start with root
        queue.insert(0);
        int v2;

        while(!queue.isEmpty()){ //until queue empty
            int v1 = queue.remove(); //remove vertex at head

            //unit it has no unvisited neigbours
            while( (v2 = graph.getAdjUnvisitedVertex(v1)) != -1){ //get one
                graph.getVertexList()[v2].wasVisited = true; //mark it

                if(graph.getVertexList()[v2].type == "post"){
                    System.out.print("- ");
                    graph.displayVertex(v2); //if of type company display it
                    System.out.println();
                }

                if(graph.getVertexList()[v2].type == "shift"){
                    break; //if of type shift it means no posts left so break
                }

                queue.insert(v2); //insert it
            }
        }

        //queue is empty, so we're done
        for(int j=0; j<graph.getnVerts(); j++){ //reset flags
            graph.getVertexList()[j].wasVisited = false;
        }
    }

    public void displayAllShifts() {
        System.out.println("Alle shifts: ");

        graph.getVertexList()[0].wasVisited = true; //start with root
        queue.insert(0);
        int v2;

        while(!queue.isEmpty()){ //until queue empty
            int v1 = queue.remove(); //remove vertex at head

            //unit it has no unvisited neigbours
            while( (v2 = graph.getAdjUnvisitedVertex(v1)) != -1){ //get one
                graph.getVertexList()[v2].wasVisited = true; //mark it

                if(graph.getVertexList()[v2].type == "shift"){
                    System.out.print("- ");
                    graph.displayVertex(v2); //if of type company display it
                    System.out.println();
                }

                queue.insert(v2); //insert it
            }
        }

        //queue is empty, so we're done
        for(int j=0; j<graph.getnVerts(); j++){ //reset flags
            graph.getVertexList()[j].wasVisited = false;
        }
    }
}
