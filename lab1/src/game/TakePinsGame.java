package game;
public class TakePinsGame {
    
    public static void main(String[]args) {
        Board b = new Board();
        
        int pins = UserInterface.askForInt("Hur många pinnar vill su spela med?");
        if (pins <= 0) {
            System.exit(0);
        }
        b.setUp(pins);


        Player[] players = new Player[2];
        players[0] = new HumanPlayer("Spelare");
        players[1] = new ComputerPlayer("HAL 9000");
        Player winner = null;

        boolean gameon = true;
        int round = 0;

        while(gameon) {
            winner = players[round];
            turn(players[round],b);
            gameon = winCheck(b);
            if (round == 0) {
                round = 1;
            } else {
                round = 0;
            }
        }
        winnerMsg(winner);

    
    }

    private static void turn(Player p, Board b) {
        UserInterface.message(p.getUserId() + " tog " + p.takePins(b) + " pinnar.");
    }

    private static boolean winCheck(Board b) {
        if (b.getNoPins() <= 0) {
            return false;
        }
        return true;
    }

    private static void winnerMsg(Player p) {
        UserInterface.message("Vinnaren är " + p.getUserId() + "!");
    }
}


