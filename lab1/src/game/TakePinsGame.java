package game;
public class TakePinsGame {
    
    public static void main(String[]args) {
        Board b = new Board();
        b.setUp(20);
        Player person = new HumanPlayer("Enar");
        Player computer = new ComputerPlayer("HAL 9000");
        boolean gameon = true;
        while(gameon) {
            
        }
        System.out.println(b.getNoPins());
    }
}
