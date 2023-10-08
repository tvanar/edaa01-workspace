package textproc;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.util.List;
import java.lang.Character;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
        // behöver bara kolla första bokstaven, ty alla siffror börjar med en siffra
        templist.removeIf(n -> Character.isDigit(n.getKey().charAt(0)));

        SortedListModel<Map.Entry<String, Integer>> listModel = new SortedListModel<>(templist);
        JList<Map.Entry<String, Integer>> list = new JList<Map.Entry<String, Integer>>(listModel);

        JScrollPane scrollPane = new JScrollPane(list);
        JRadioButton alpha = new JRadioButton("Alphabetical");
        JRadioButton freq = new JRadioButton("Frequency");
        ButtonGroup Bgroup = new ButtonGroup();
        Bgroup.add(alpha);
        Bgroup.add(freq);

        JPanel panel = new JPanel();
        panel.add(freq);
        panel.add(alpha);
        JButton search = new JButton("Sort");
        panel.add(search);

        // xD det funkar direkt
        search.addActionListener(e -> {
            if (alpha.isSelected()) {
                listModel.sort((w1, w2) -> w1.getKey().compareTo(w2.getKey()));
            } else if (freq.isSelected()) {
                listModel.sort((w1, w2) -> w2.getValue() - w1.getValue());
            } else {
                JOptionPane.showMessageDialog(new JFrame("msg"), "Välj en knapp");
            }

        });

        JTextField searchbar = new JTextField(15);
        JButton find = new JButton("Find");

        searchbar.addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent e) {
                // används inte
            }

            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    list.ensureIndexIsVisible(search(listModel, searchbar));
                }
            }

            public void keyReleased(KeyEvent e) {
                // används inte
            }
        });

        // LOL satt i 10 min på att jag glömde bort att string comparison i java kräver
        // ==
        // jag har skrivit för mycket python
        find.addActionListener(e -> list.ensureIndexIsVisible(search(listModel, searchbar)));

        panel.add(searchbar);
        panel.add(find, BorderLayout.EAST);

        pane.add(scrollPane);
        pane.add(panel, BorderLayout.SOUTH);

        pane.setSize(width, height);
        frame.pack();
        frame.setVisible(true);
    }

    private int search(SortedListModel<Map.Entry<String, Integer>> lm, JTextField input) {
        for (int i = 0; i < lm.getSize(); i++) {
            if (lm.getElementAt(i).getKey().equals(input.getText().trim().toLowerCase())) {
                return i;
            }
        }
        JOptionPane.showMessageDialog(new JFrame("msg"), "Ordet finns ej i listan");
        return 0; //skrollar högst upp på listan
    }

}
