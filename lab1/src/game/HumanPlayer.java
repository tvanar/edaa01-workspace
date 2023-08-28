package game;

public class HumanPlayer extends Player { 

    HumanPlayer (String userId) {
        super(userId);
    }
    
    int takePins (Board b) {
        int pinsLeft = b.getNoPins();
        int pinsTaken = UserInterface.askForInt("Din tur.\nDet finns " + pinsLeft + "pinnar kvar.\nHur många vill du ta?");
        b.takePins(pinsTaken);
        return pinsTaken;
    }
}
