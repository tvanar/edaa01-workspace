package textproc;

// import java.util.HashMap;
// import java.util.Map;
import java.util.TreeMap;

public class MultiWordCounter implements TextProcessor {

    private TreeMap<String, Integer> words = new TreeMap<>();

    /*
     * Kanske någonting lurt med stringComp
     */

    public MultiWordCounter(String[] wordArray) {
        for (int i = 0; i < wordArray.length; i++) {
            words.put(wordArray[i], 0);
        }
    }

    public void process(String w) {
        if (words.containsKey(w)) {
            words.compute(w, (k, v) -> v + 1);
        }
    }

    public void report() {
        words.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
