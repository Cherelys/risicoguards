package sr.unasat.risicoguards.datastractures;

public class Guard {
    public String name; //John Doe
    public int skillset; //0-100

    public Guard(String name, int skillset) {
        this.name = name;
        this.skillset = skillset;
    }

    public void display(){
        System.out.print(this.name + "[" + this.skillset + "]");
    }

}
