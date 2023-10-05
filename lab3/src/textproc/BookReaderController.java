package textproc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.util.List;
import java.lang.Character;

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
        frame.setSize(width, height);
        Container pane = frame.getContentPane();

        List<Map.Entry<String, Integer>> templist = counter.getWordList();
        // Borde gå att korta ned
        templist.removeIf(n -> {
            String temp = n.getKey();
            for (int i = 0; i < temp.length(); i++) {
                if (Character.isDigit(temp.charAt(i))) {
                    return true;
                }
            }
            return false;
        });

        SortedListModel<Map.Entry<String, Integer>> listModel = new SortedListModel<>(templist);
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

        JTextField searchbar = new JTextField(10);
        JButton find = new JButton("Find");

        find.addActionListener(e -> {
            for(int i = 0; i < listModel.getSize(); i++) {
                if(listModel.getElementAt(i).getKey() == searchbar.getText()) {
                    list.ensureIndexIsVisible(i);
                }
            }
        });

        panel.add(searchbar);
        panel.add(find, BorderLayout.EAST);

        pane.add(scrollPane);
        pane.add(panel, BorderLayout.SOUTH);
        // pane.add(searchbar,BorderLayout.EAST);

        frame.pack();
        frame.setVisible(true);
    }

}
