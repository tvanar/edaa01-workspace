package textproc;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.Container;


public class BookReaderController {
   
    
    public BookReaderController(GeneralWordCounter counter) {
        SwingUtilities.invokeLater(() -> createWindow(counter, "BookReader", 200, 600));
    }

    private void createWindow(GeneralWordCounter counter, String title, int width, int height) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = frame.getContentPane();
        // pane är en behållarkomponent till vilken de övriga komponenterna
        frame.pack();
        frame.setVisible(true);
    }

}
