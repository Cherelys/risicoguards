package sr.unasat.risicoguards.datastractures;

public class Vertex {
        public String name;
        public String type;
        public boolean wasVisited;
        public boolean isInTree;
        public boolean isFull;

        public Vertex(String name, String type) {
            this.name=name;
            this.type=type;
            wasVisited = false;
            isInTree = false;
            isFull = false;
        }
}
