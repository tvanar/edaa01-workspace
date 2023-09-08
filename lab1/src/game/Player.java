package game;

public abstract class Player {

    private String userId;

    Player(String userId) {
        this.userId = userId;
    }

    /**
     * Returnerar UserId string
     */
    String getUserId() {
        return userId;
    }

    /*
     * Abstrakt metod för att ta pins: implementeras sedan i subklasser
     */
    abstract int takePins(Board b);
}
