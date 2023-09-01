package textproc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GeneralWordCounter implements TextProcessor {

    private Set<String> stopwords;
    private Map<String, Integer> words = new HashMap<>();

    public GeneralWordCounter(Set<String> in) {
        stopwords = in;
    }

    public void process(String w) {
        if (stopwords.contains(w)) {
            return;
        } else if (!words.containsKey(w)) {
            words.put(w, 1);
            return;
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

        //wordList.sort((w1, w2) -> w2.getValue() - w1.getValue());

        for (Map.Entry<String, Integer> word: wordSet) {
            System.out.println(word.getKey() + " " + word.getValue());
        }

        
    }
}
