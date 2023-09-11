package textproc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import java.awt.Container;
import java.util.Map;

public class BookReaderController {

    public BookReaderController(GeneralWordCounter counter) {
        SwingUtilities.invokeLater(() -> createWindow(counter, "BookReader", 1440, 900));
    }

    private void createWindow(GeneralWordCounter counter, String title, int width, int height) {

        
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = frame.getContentPane();

        SortedListModel<Map.Entry<String, Integer>> listModel = new SortedListModel<>(counter.getWordList());
        JList<Map.Entry<String, Integer>> list = new JList<Map.Entry<String, Integer>>(listModel);
                

        JScrollPane scrollPane = new JScrollPane(list);
        JButton button = new JButton("Alphabetical");

        

        pane.add(scrollPane);
        pane.add(button);

        frame.pack();
        frame.setVisible(true);
    }

}
