package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BookReaderApplication {
    
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scan = new Scanner(new File("lab3\\undantagsord.txt"));
		Set<String> stopwords = new HashSet<>();
		while(scan.hasNext()) {
			stopwords.add(scan.next().toLowerCase());
		}
		scan.close();
        GeneralWordCounter wordCounter = new GeneralWordCounter(stopwords);

        Scanner s = new Scanner(new File("lab2\\nilsholg.txt"));
		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+");
        while (s.hasNext()) {
            wordCounter.process(s.next().toLowerCase());
        }
        s.close();
        wordCounter.report();

    }
}
