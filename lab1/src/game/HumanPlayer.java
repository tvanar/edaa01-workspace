package game;

public class HumanPlayer extends Player {

    HumanPlayer(String userId) {
        super(userId);
    }

    int takePins(Board b) {
        int pinsLeft = b.getNoPins();
        int pinsTaken = 0;

        while (true) {
            pinsTaken = UserInterface
                    .askForInt("Din tur.\nDet finns " + pinsLeft + " pinnar kvar.\nHur många vill du ta?");
            if ((pinsTaken == 1 || pinsTaken == 2) && pinsTaken <= b.getNoPins()) {
                break;
            } else if (pinsTaken == -2) {
                System.exit(0);
            } else {
                UserInterface.message("Välj ett tal, ett eller två");
            }
        }
        b.takePins(pinsTaken);
        return pinsTaken;
    }
}
