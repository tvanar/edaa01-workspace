package textproc;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import java.awt.Container;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class BookReaderController {

    public BookReaderController(GeneralWordCounter counter) {
        SwingUtilities.invokeLater(() -> createWindow(counter, "BookReader", 200, 600));
    }

    private void createWindow(GeneralWordCounter counter, String title, int width, int height) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = frame.getContentPane();
        JList<SortedListModel<List<Map.Entry<String, Integer>>>> list = createList(counter);
        JScrollPane scrollPane = new JScrollPane(list);
        pane.add(scrollPane);
        frame.pack();
        frame.setVisible(true);
    }

    private JList<SortedListModel<List<Map.Entry<String, Integer>>>> createList(GeneralWordCounter counter) {
        List<Map.Entry<String, Integer>> wordList = counter.getWordList();
        JList<SortedListModel<List<Map.Entry<String, Integer>>>> list = new JList<SortedListModel<List<Map.Entry<String, Integer>>>>();
        DefaultListModel<Map.Entry<String, Integer>> temp = new ArrayList<>();
        return list;
    }

}
