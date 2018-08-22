package sr.unasat.risicoguards.datastractures;

//class used for inserting new guards so that they are already sorted to use
public class PriorityQ {
    private int maxSize;
    private Guard[] guards;
    private int nGuards;

    public PriorityQ(int maxSize) {
        this.maxSize = maxSize;
        guards = new Guard[maxSize];
        nGuards = 0;
    }

    public void insert(Guard guard){
        int j;

        if(nGuards == 0){ //if no guards
            guards[nGuards++] = guard; //insert at 0
        }else{ //if guards
            for (j = nGuards-1; j>=0; j--){ //start at end
                if(guard.skillset < guards[j].skillset){ //if new guard less
                    guards[j+1] = guards[j];  //shift upwards
                }else{
                    break; //if larger, done shifting
                }
            }

            guards[j+1] =  guard;
            nGuards++;
        }
    }

    public Guard remove(){
        return guards[--nGuards]; //remove item
    }

    public Guard peekMax(){
        return guards[nGuards - 1]; //peek at maximum item
    }

    public boolean isEmpty(){
        return (nGuards == 0); //true if q is empty
    }

    public boolean isFull(){
        return (nGuards == maxSize); //true if q is full
    }
}
