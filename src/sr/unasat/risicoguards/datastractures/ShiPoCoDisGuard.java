package sr.unasat.risicoguards.datastractures;

public class ShiPoCoDisGuard {
    public int shift;
    public int post;
    public int company;
    public int distance;
    public Guard guard;

    public ShiPoCoDisGuard(int shift, int post, int company, int distance, Guard guard) {
        this.shift = shift;
        this.post = post;
        this.company = company;
        this.distance = distance;
        this.guard = guard;
    }
}
