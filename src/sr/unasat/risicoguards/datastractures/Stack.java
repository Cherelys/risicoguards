package sr.unasat.risicoguards.datastractures;

public class Stack {
    private int[] st;
    private int top;

    public Stack(){
        st = new int[Graph.MAX_VERTS];
        top = -1;
    }

    public void push(int j){ //put item on stack
        st[++top] = j;
    }

    public int pop(){ //take item from stack
        return st[top--];
    }

    public int peek(){ //peek at top of stack
        return st[top];
    }

    public boolean isEmpty(){ //check if stack empty
        return top == -1;
    }
}
