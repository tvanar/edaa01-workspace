package game;

import java.util.Random;

public class ComputerPlayerRandom extends Player {
    
        ComputerPlayerRandom(String userId) {
        super(userId);
    }

    int takePins (Board b) {
        Random r = new Random();
        int pinsTaken = r.nextInt(2) + 1;
        b.takePins(pinsTaken);
        return 0;
    }
}
