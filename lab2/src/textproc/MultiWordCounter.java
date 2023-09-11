package textproc;

// import java.util.HashMap;
// import java.util.Map;
import java.util.TreeMap;

public class MultiWordCounter implements TextProcessor {

    private TreeMap<String, Integer> words = new TreeMap<>();

    /*
     * Någonting lurt med denna klass. Alla andra klasser fungerar utom denna. Kolla på resurstid.
     */

    public MultiWordCounter(String[] wordArray) {
        for (int i = 0; i < wordArray.length; i++) {
            words.put(wordArray[i], 0);
        }
    }

    @Override
    public void process(String w) {
        if (words.containsKey(w)) {
            words.compute(w, (k, v) -> v + 1);
        }
    }

    @Override
    public void report() {
        words.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
