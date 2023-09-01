package textproc;

import java.util.HashMap;
import java.util.Map;

public class MultiWordCounter implements TextProcessor {

    private Map<String, Integer> words = new HashMap<>();

    public MultiWordCounter(String[] wordArray) {
        for (int i = 0; i < wordArray.length; i++) {
            words.put(wordArray[i], 0);
        }
    }

    public void process(String w) {
        for (String key : words.keySet()) {
            if (key.equals(w)) {
                words.put(key, words.get(key) + 1);
            }
        }
    }

    public void report() {
        words.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
