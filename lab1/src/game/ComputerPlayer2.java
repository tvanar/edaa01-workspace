package game;

import java.util.Random;

public class ComputerPlayer2 extends Player {

    public ComputerPlayer2(String userId) {
        super(userId);
    }

    int takePins(Board b) {
        Random r = new Random();
        int pinsToTake = b.getNoPins() % 3;
        if (pinsToTake == 1 || pinsToTake == 2) {
            b.takePins(pinsToTake);
        } else {
            pinsToTake = r.nextInt(2)+1;
            b.takePins(pinsToTake);
        }
        return pinsToTake;
    }
}
