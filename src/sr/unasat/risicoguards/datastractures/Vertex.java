package sr.unasat.risicoguards.datastractures;

public class Vertex {
        public char label;
        public boolean wasVisited;
        public boolean isInTree;

        public Vertex(char lab) {
            label=lab;
            wasVisited = false;
            isInTree = false;
        }
}
