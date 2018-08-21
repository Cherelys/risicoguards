package sr.unasat.risicoguards.algorithms;

import sr.unasat.risicoguards.datastractures.Graph;
import sr.unasat.risicoguards.datastractures.Stack;

public class DFS {
    private Graph graph;
    private Stack stack;

    public DFS(Graph graph){
        this.graph = graph;
        this.stack = new Stack();
    }

    public void search(){ //depth-first search
        graph.getVertexList()[0].wasVisited = true; //begin at vertex 0, mark it
        graph.displayVertex(0); // display it
        stack.push(0); // push it

        while (!stack.isEmpty()){ //until stack is empty
            //get an unvisited vertex adjacent to stack top
            int v = graph.getAdjUnvisitedVertex(stack.peek());
            if(v == -1) { //if no such vertex
                stack.pop();
            }else{ //if it exists
                graph.getVertexList()[v].wasVisited = true; //mark it
                graph.displayVertex(v); //display it
                stack.push(v); //push it
            }
        } //end while

        //stack is empty, so we're done
        for(int j=0; j<graph.getnVerts(); j++){
            graph.getVertexList()[j].wasVisited = false;
        } //end dfs
    }

    public void displayCompany(String name) {
        boolean rightCompany = false;
        int companyCountWhenRight = 0;
        graph.getVertexList()[0].wasVisited = true; //start at root, mark it
        stack.push(0); // push it

        while (!stack.isEmpty()){ //until stack is empty
            //get an unvisited vertex adjacent to stack top
            int v = graph.getAdjUnvisitedVertex(stack.peek());
            if(v == -1) { //if no such vertex
                stack.pop();
            }else{ //if it exists
                graph.getVertexList()[v].wasVisited = true; //mark it

                if(graph.getVertexList()[v].type == "company" && graph.getVertexList()[v].name == name){
                    rightCompany = true;
                }

                if(graph.getVertexList()[v].type == "company" && rightCompany){
                    companyCountWhenRight++;
                }

                if(rightCompany && companyCountWhenRight == 1){
                    if(graph.getVertexList()[v].type == "post"){
                        System.out.print("- ");
                    }

                    if(graph.getVertexList()[v].type == "shift"){
                        System.out.print("    - ");
                    }

                    graph.displayVertex(v); //display if right company and next company didn't arrive yet

                    if(graph.getVertexList()[v].type == "company"){
                        System.out.println(": ");
                    }else{
                        System.out.println();
                    }
                }

                stack.push(v); //push it
            }

            if(companyCountWhenRight > 1){
                break; //break if company needed already displayed
            }


        } //end while

        //stack is empty, so we're done
        for(int j=0; j<graph.getnVerts(); j++){
            graph.getVertexList()[j].wasVisited = false;
        } //end dfs
    }

    public void displayPosts(String name) {
        boolean rightCompany = false;
        int companyCountWhenRight = 0;
        graph.getVertexList()[0].wasVisited = true; //start at root, mark it
        stack.push(0); // push it

        while (!stack.isEmpty()){ //until stack is empty
            //get an unvisited vertex adjacent to stack top
            int v = graph.getAdjUnvisitedVertex(stack.peek());
            if(v == -1) { //if no such vertex
                stack.pop();
            }else{ //if it exists
                graph.getVertexList()[v].wasVisited = true; //mark it

                if(graph.getVertexList()[v].type == "company" && graph.getVertexList()[v].name == name){
                    rightCompany = true;
                }

                if(graph.getVertexList()[v].type == "company" && rightCompany){
                    companyCountWhenRight++;
                }

                if(rightCompany && companyCountWhenRight == 1){
                    if(graph.getVertexList()[v].type == "company"){
                        System.out.print("Alle posten van ");
                    }

                    if(graph.getVertexList()[v].type == "post"){
                        System.out.print("- ");
                    }

                    if(graph.getVertexList()[v].type != "shift"){
                        graph.displayVertex(v); //display if right company and not of type shift
                    }

                    if(graph.getVertexList()[v].type == "company"){
                        System.out.println(": ");
                    }else if(graph.getVertexList()[v].type == "post"){
                        System.out.println();
                    }
                }

                stack.push(v); //push it
            }

            if(companyCountWhenRight > 1){
                break; //break if company needed already displayed
            }


        } //end while

        //stack is empty, so we're done
        for(int j=0; j<graph.getnVerts(); j++){
            graph.getVertexList()[j].wasVisited = false;
        } //end dfs
    }

    public void displayShifts(String post) {
        boolean rightPost = false;
        int postCountWhenRight = 0;
        graph.getVertexList()[0].wasVisited = true; //start at root, mark it
        stack.push(0); // push it

        while (!stack.isEmpty()){ //until stack is empty
            //get an unvisited vertex adjacent to stack top
            int v = graph.getAdjUnvisitedVertex(stack.peek());
            if(v == -1) { //if no such vertex
                stack.pop();
            }else{ //if it exists
                graph.getVertexList()[v].wasVisited = true; //mark it

                if(graph.getVertexList()[v].type == "post" && graph.getVertexList()[v].name == post){
                    rightPost = true;
                }

                if(graph.getVertexList()[v].type == "post" && rightPost){
                    postCountWhenRight++;
                }

                if(rightPost && postCountWhenRight == 1){
                    if(graph.getVertexList()[v].type == "post"){
                        System.out.print("Alle shifts van ");
                    }

                    if(graph.getVertexList()[v].type == "shift"){
                        System.out.print("- ");
                    }

                    if(graph.getVertexList()[v].type != "company"){
                        graph.displayVertex(v); //display if right post and not of type company
                    }

                    if(graph.getVertexList()[v].type == "post"){
                        System.out.println(": ");
                    }else{
                        System.out.println();
                    }
                }

                stack.push(v); //push it
            }

            if(postCountWhenRight > 1){
                break; //break if company needed already displayed
            }


        } //end while

        //stack is empty, so we're done
        for(int j=0; j<graph.getnVerts(); j++){
            graph.getVertexList()[j].wasVisited = false;
        } //end dfs
    }
}
