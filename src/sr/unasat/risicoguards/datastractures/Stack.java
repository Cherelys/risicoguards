package sr.unasat.risicoguards.datastractures;

public class Stack {
    private final int SIZE = 20;
    private int[] st;
    private int top;

    public Stack(){
        st = new int[SIZE];
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
