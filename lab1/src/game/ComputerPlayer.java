package game;

import java.util.Random;

public class ComputerPlayer extends Player {

    ComputerPlayer(String userId) {
        super(userId);
    }

    /**
     * Tar ett slupmässigt 1 eller två pinnar, om det inte är >= 2 pinnar kvar. Isf
     * tar den resterande och vinner.
     */
    int takePins(Board b) {
        Random r = new Random();
        int pinsTaken;
        if (b.getNoPins() <= 2) {
            pinsTaken = b.getNoPins();
            b.takePins(pinsTaken);
        } else {
            pinsTaken = r.nextInt(2) + 1;
            b.takePins(pinsTaken);
        }
        return pinsTaken;
    }
}
