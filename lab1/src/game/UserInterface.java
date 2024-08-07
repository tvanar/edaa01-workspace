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
        String out = JOptionPane.showInputDialog(f, msg);
        if (out != null) {
            try {
                return Integer.parseInt(out);
            } catch (NumberFormatException e) {
                return -1;
            }
        }
        return -2;
    }
}
