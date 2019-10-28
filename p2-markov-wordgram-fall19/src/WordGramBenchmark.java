import java.io.*;
import java.util.*;

public class WordGramBenchmark {
	public final static int WSIZE = 4;

	public static int benchmark(Set<WordGram> set, String filename) throws FileNotFoundException {
		Scanner scan = new Scanner(new File(filename));

		//add every string from our scanned file into list
		ArrayList<String> list = new ArrayList<>();
		while (scan.hasNext()) {
			String s = scan.next();
			list.add(s);
		}
		scan.close();
		String[] words = list.toArray(new String[0]);

		//loop through each word in list (-WSIZE + 1) so we don't have any partial wordgrams (need to leave room for the size of the WordGram)
		for(int k=0; k < words.length - WSIZE + 1; k += 1) {
			WordGram wg = new WordGram(words,k,WSIZE); //create new wordgram each time starting at index k
			set.add(wg); //add to set of wordgrams
		}
		return words.length - WSIZE + 1;
	}
	public static int benchmarkShift(Set<WordGram> set, String filename) throws FileNotFoundException {
		Scanner scan = new Scanner(new File(filename));

		String[] words = new String[WSIZE];
		for(int k=0; k < WSIZE; k += 1) {
			words[k] = scan.next();
		}
		int count = WSIZE;
		WordGram current = new WordGram(words,0,WSIZE);
		set.add(current);

		//while there are more words in the file to scan
		while (scan.hasNext()) {
			String s = scan.next();		
			current = current.shiftAdd(s); //append s to our current wordgram and shift it once
			set.add(current); //add this new shifted wordgram to our set of wordgrams
			count += 1; //increase count to know how many times we've done this
		}
		scan.close();
		return count - WSIZE + 1; //bc we started at count = WSIZE, so we need to offset it
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		String[] plays = {"allswell.txt",
				"caesar.txt",	"errors.txt",
				"hamlet.txt", "likeit.txt", "macbeth.txt",
				"romeo.txt", "tempest.txt"};

		HashSet<WordGram> hset = new HashSet<>();
		HashSet<WordGram> hset2 = new HashSet<>();

		double start,end,time;

		// calculate stats for running benchmark
		
		int total = 0;
		start = System.nanoTime();
		for(String play : plays) {
			String fname = "data/shakes/" + play;
			total += benchmark(hset,fname);
		}
		end = System.nanoTime();
		time = (end-start)/1e9;

		System.out.printf("benchmark time: %1.3f, size = %d\n",time,hset.size());
		System.out.printf("total # wgs = %d\n",total);
		
		// calculate stats for running benchmarkShift
		
		total = 0;
		start = System.nanoTime();
		for(String play : plays) {
			String fname = "data/shakes/" + play;
			total += benchmarkShift(hset2,fname);
		}
		end = System.nanoTime();
		time = (end-start)/1e9;

		System.out.printf("\nbenchmarkShift time: %1.3f, size = %d\n",time,hset2.size());
		System.out.printf("total # wgs = %d\n",total);
		
		HashSet<WordGram> copy = new HashSet<>(hset);
		HashSet<WordGram> copy2 = new HashSet<>(hset2);
		
		copy.removeAll(hset2);
		copy2.removeAll(hset);
		
		System.out.printf("\nsize of set difference %d\n", copy.size());
		System.out.printf("size of set2 difference %d\n", copy2.size());
	}
}
