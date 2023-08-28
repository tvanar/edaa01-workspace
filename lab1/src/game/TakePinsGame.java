package game;
public class TakePinsGame {
    
    public static void main(String[]args) {
        Board b = new Board();
        b.setUp(20);
        Player person = new HumanPlayer("Enar");
        person.takePins(b);
        System.out.println(b.getNoPins());
    }
}
