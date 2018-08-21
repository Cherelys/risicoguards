package sr.unasat.risicoguards.datastractures;

public class Queue {
    private int[] queueArray;
    private int front;
    private int rear;

    public Queue(){
        queueArray = new int[Graph.MAX_VERTS];
        front = 0;
        rear = -1;
    }

    public void insert(int j){ //put item at rear of queue
        if(rear == Graph.MAX_VERTS-1){
            rear = -1;
        }
        queueArray[++rear] = j;
    }

    public int remove(){ //take item from front of queue
        int temp = queueArray[front++];
        if(front == Graph.MAX_VERTS){
            front = 0;
        }
        return temp;
    }

    public boolean isEmpty(){ //true if queue is empty
        return (rear+1 == front || (front+Graph.MAX_VERTS-1 == rear));
    }
}
