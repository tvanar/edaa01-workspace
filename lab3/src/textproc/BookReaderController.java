package textproc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import java.awt.BorderLayout;
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
        JButton alpha = new JButton("Alphabetical");
        JButton freq = new JButton("Frequency");
        JPanel panel = new JPanel();
        panel.add(alpha);
        panel.add(freq);
        

        /*
         * gör något när man trycker på knappen
         * e:et ska vara där tydl. annars bara labdautrryck.
         */
        alpha.addActionListener(e -> listModel.sort((w1, w2) -> w1.getKey().compareTo(w2.getKey())));
        freq.addActionListener(e -> listModel.sort((w1, w2) -> w2.getValue() - w1.getValue()));
        
        JTextField searchbar = new JTextField();
        JButton find = new JButton("Find");

        // find.addActionListener();


        panel.add(searchbar);
        panel.add(find, BorderLayout.EAST);

        pane.add(scrollPane);
        pane.add(panel, BorderLayout.SOUTH);
        // pane.add(searchbar,BorderLayout.EAST);
        
        frame.pack();
        frame.setVisible(true);
    }

}
