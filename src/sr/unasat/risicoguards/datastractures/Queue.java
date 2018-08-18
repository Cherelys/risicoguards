package sr.unasat.risicoguards.datastractures;

public class Queue {
    private final int SIZE = 20;
    private int[] queueArray;
    private int front;
    private int rear;

    public Queue(){
        queueArray = new int[SIZE];
        front = 0;
        rear = -1;
    }

    public void insert(int j){ //put item at rear of queue
        if(rear == SIZE-1){
            rear = -1;
        }
        queueArray[++rear] = j;
    }

    public int remove(){ //take item from front of queue
        int temp = queueArray[front++];
        if(front == SIZE){
            front = 0;
        }
        return temp;
    }

    public boolean isEmpty(){ //true if queue is empty
        return (rear+1 == front || (front+SIZE-1 == rear));
    }
}
