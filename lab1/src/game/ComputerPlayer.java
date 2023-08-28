package game;

import java.util.Random;

public class ComputerPlayer extends Player{
    
    ComputerPlayer(String userId) {
        super(userId);
    }

    int takePins (Board b) {
        Random r = new Random();
        int pinsLeft = b.getNoPins();
        if (pinsLeft == 2) {
            b.takePins(1);
        } else {

        }
        return 0;
    }
}
