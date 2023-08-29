package game;
public class TakePinsGame {
    
    public static void main(String[]args) {
        Board b = new Board();
        b.setUp(20);
        Player person = new HumanPlayer("Enar");
        Player computer = new ComputerPlayer("HAL 9000");
        boolean gameon = true;
        while(gameon) {
            turn(person,b);
            gameon = winCheck(b);
            
        }
        System.out.println(b.getNoPins());

    
    }

    private static void turn(Player p, Board b) {
        p.takePins(b);
    }

    private static boolean winCheck(Board b) {
        if (b.getNoPins() <= 0) {
            return false;
        }
        return true;
    }
}


