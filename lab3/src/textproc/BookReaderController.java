package textproc;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.SwingUtilities;
import java.awt.Container;
import java.util.List;
import java.util.Map;


public class BookReaderController {
   
    private GeneralWordCounter counter;

    public BookReaderController(GeneralWordCounter counter) {
        this.counter = counter;
        SwingUtilities.invokeLater(() -> createWindow(counter, "BookReader", 200, 600));
    }

    private void createWindow(GeneralWordCounter counter, String title, int width, int height) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = frame.getContentPane();
        JList<SortedListModel<List<Map.Entry<String, Integer>>>> list = createList();
        pane.add(list);
        frame.pack();
        frame.setVisible(true);
    }

    private JList<SortedListModel<List<Map.Entry<String, Integer>>>> createList() {
        JList<SortedListModel<List<Map.Entry<String, Integer>>>> list = new JList<SortedListModel<List<Map.Entry<String, Integer>>>>();
        return list;
    }

}
