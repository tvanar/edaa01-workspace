package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Holgersson {

	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };

	public static void main(String[] args) throws FileNotFoundException {


		Scanner scan = new Scanner(new File("lab2\\undantagsord.txt"));
		Set<String> stopwords = new HashSet<>();
		while(scan.hasNext()) {
			stopwords.add(scan.next().toLowerCase());
		}
		scan.close();


		ArrayList<TextProcessor> pList = new ArrayList<TextProcessor>();
		pList.add(new SingleWordCounter("nils"));
		pList.add(new SingleWordCounter("norge"));
		pList.add(new MultiWordCounter(REGIONS));
		pList.add(new GeneralWordCounter(stopwords));
		

		Scanner s = new Scanner(new File("lab2\\n" + //
				"ilsholg.txt"));
		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning

		while (s.hasNext()) {
			String word = s.next().toLowerCase();
			for(TextProcessor p: pList) {
				p.process(word);
			}
			
		}

		s.close();

		for(TextProcessor p: pList) {
			p.report();
		}
	}
}