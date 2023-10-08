package textproc;

import java.util.ArrayList;
// import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class GeneralWordCounter implements TextProcessor {

    private Set<String> stopwords;
    private TreeMap<String, Integer> words = new TreeMap<>();
    // private Map<String, Integer> words = new HashMap<>();

    //denna klass fungerar

    public GeneralWordCounter(Set<String> in) {
        stopwords = in;
    }

    public void process(String w) {
        if (stopwords.contains(w)) {
            return;
        } else if (!words.containsKey(w)) {
            words.put(w, 1);
        } else {
            for (String key : words.keySet()) {
                if (key.equals(w)) {
                    words.put(key, words.get(key) + 1);
                }
            }
        }
    }

    public void report() {
        Set<Map.Entry<String, Integer>> wordSet = words.entrySet();
        List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);

        wordList.sort((w1, w2) -> {
            int wtemp = w2.getValue() - w1.getValue();
            if(wtemp != 0) {
                return wtemp;
            } else {
                return w1.getKey().compareTo(w2.getKey());
            }

        });

        for (int i = 0; i < 10; i++) {
            System.out.println(wordList.get(i).getKey() + " " + wordList.get(i).getValue());
        }
    }

    /**
     * Returnerar en Lista av typ Map.Entry med alla ord
     * @return returns a list of type Map.Entry(String, Integer) with all words
     */
    public List<Map.Entry<String, Integer>> getWordList() {
        return new ArrayList<Map.Entry<String, Integer>>(words.entrySet());
    }
}
