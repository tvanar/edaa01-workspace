package game;
public class Board {
    
    private int pins;

    Board() {

    }

    /*
     * Sätter upp spelbrädet med ett antal pins.
     */
    public void setUp(int pins) {
        this.pins = pins;
    }

    /*
     * Subtraherar antalet pins som tas från de totala
     */
    public void takePins(int pins) {
        this.pins -= pins;
    }

    /*
     * Returnerar antalet pins kvar i brädet
     */
    public int getNoPins() {
        return pins;
    }
}
