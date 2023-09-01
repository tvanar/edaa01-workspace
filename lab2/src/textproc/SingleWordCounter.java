package textproc;

public class SingleWordCounter implements TextProcessor {
	private String word;
	private int n;

	public SingleWordCounter(String word) {
		this.word = word;
		n = 0;
	}

	//Man kan inte jämföra strings med "=="

	public void process(String w) {
		if (w.equals(word)) {
			n++;
		}
	}

	public void report() {
		System.out.println(word + ": " + n);
	}

}
