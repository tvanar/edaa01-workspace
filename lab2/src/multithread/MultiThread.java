package multithread;

import java.io.File;
import java.util.Scanner;

import textproc.*;

public class MultiThread extends Thread {
    
    private TextProcessor p;
    private int thread;
    private String m;

    public MultiThread (TextProcessor p, int thread) {
        this.thread = thread;
        this.p = p;
    }

    @Override
    public void run() {
        Scanner s = new Scanner(new File(""));
		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning

		long t0 = System.nanoTime();

		while (s.hasNext()) {
			String word = s.next().toLowerCase();
			p.process(word);
		}
    }
}
