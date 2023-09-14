package multithread;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import textproc.*;

public class Holgerv2 {

	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };

	public static void main(String[] args) throws FileNotFoundException {


		// Scanner scan = new Scanner(new File("lab2\\undantagsord.txt"));
		// Set<String> stopwords = new HashSet<>();
		// while(scan.hasNext()) {
		// 	stopwords.add(scan.next().toLowerCase());
		// }
		// scan.close();

		// SingleWordCounter p1 = new SingleWordCounter("nils");
		// SingleWordCounter p2 = new SingleWordCounter("norge");
		// MultiWordCounter p3 = new MultiWordCounter(REGIONS);
		// GeneralWordCounter p4 = new GeneralWordCounter(stopwords);

		// File f = new File("lab2\\nilsholg.txt");
		// long t0 = System.nanoTime();
        
		// MultiThread th1 = new MultiThread(p1,1, f);
		// MultiThread th2 = new MultiThread(p2,2, f);
		// MultiThread th3 = new MultiThread(p3,3, f);
		// MultiThread th4 = new MultiThread(p4, 4, f);

		// long t1 = System.nanoTime();
		// th1.start();
		// th2.start();
		// th3.start();
		// th4.start();

		// p1.report();
		// p2.report();
		// p3.report();
		// p4.report();

		// System.out.println("tid: " + (t1 - t0) / 1000000.0 + " ms");
	}
}
