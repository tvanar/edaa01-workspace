package game;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.lang.Integer;

public class UserInterface {
    
    private static JFrame f;

    UserInterface() {
        f = new JFrame();
    }

    public static void message(String msg) {
        JOptionPane.showMessageDialog(f, msg);
    }
    /*
     * Frågar efter en int
     */
    public static int askForInt(String msg) {
        int numberOfPins;
        String out = JOptionPane.showInputDialog(f, msg);
        //kollar om man trycker cancel
        if(out == null) {
            System.exit(0);
        }
        /*
         * Kollar så man skriver en siffra, annars returnerar den en nolla vilket leder till att den failar i nästa 
         * stadie.
         */
        try {
            numberOfPins = Integer.parseInt(out);
        } catch(NumberFormatException e) {
            return 0;
        }
        return numberOfPins;
    }
}
