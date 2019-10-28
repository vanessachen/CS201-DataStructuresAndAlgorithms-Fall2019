import java.util.ArrayList;
import java.util.Arrays;

/**
 * A WordGram represents a sequence of strings
 * just as a String represents a sequence of characters
 * 
 * @author Vanessa Chen
 *
 */
public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram by creating instance variable myWords and copying
	 * size strings from source starting at index start
	 * @param source is array of strings from which copying occurs
	 * @param start starting index in source for strings to be copied
	 * @param size the number of strings copied
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		myToString = null;
		myHash = 0;

		// TODO: initialize all instance variable
		//copies a subsequence components of a specified source array, begins at a specified position of source array
		//to the specified position of destination array
		System.arraycopy(source, start, myWords, 0, size);
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * This method computes and returns the length of the myWords array
	 * @return the length of the myWords array, which is equivalent to the order of the WordGram
	 */
	public int length(){
		// TODO: change this
		return myWords.length;
	}


	/**
	 * Override the .equals() method that comes with the Java Object class
	 * Return false if object o is not a WordGram, or if it is null
	 * Return true if object is a WordGram with the same strings in the same order as this object (to the left of '.')
	 * @param o is the object that will be checked for 'equality' compared to this object (the object to the left of '.')
	 * @return Boolean false if object is not a WordGram,
	 * @return true if o is a WordGram with the same strings in the same order as this object
	 */
	@Override
	public boolean equals(Object o) {

		boolean tempBool = true;
		WordGram wg = (WordGram) o;
		if (!(o instanceof WordGram) || o == null) {
			return false;
		}
		if ((o instanceof WordGram) && (wg instanceof WordGram)){
				if (!Arrays.equals(this.myWords,wg.myWords)){
					return false;
			}
		}
		if (this.length()!=wg.length()){
			return false;
		}
		// TODO: Complete this method

		return true;
	}
	/**
	 * Return the hashcode of our joined wordgram string
	 * @return the value of the hashcode of source array that has been joined as a string (by " ")
	 */
	@Override
	public int hashCode(){
		// TODO: complete this method
		myHash = this.toString().hashCode();
		return myHash;
	}
	

	/**
	 * Create and return a new WordGram object of order k, where the first k-1 entries are equivalent to the last k-1
	 * entries of the WordGram this method is applied to. The last entry in this new WordGram becomes param last.
	 * Steps:
	 * 1) Create arraylist, and add everything from myWords starting at index 1 to the size of the Wordgram.
	 * 2) Add last to the end of the arraylist
	 * 3) Convert arraylist back into array
	 * 4) Create new WordGram from this array.
	 * @param last is last String of returned WordGram
	 * @return
	 */
	public WordGram shiftAdd(String last) {
		//WordGram wg = new WordGram(myWords,0,myWords.length);
		// TODO: Complete this method
		ArrayList<String> newArraylist = new ArrayList<String>();
		//start at i=1 so we skip the first value
		for (int i = 1; i < myWords.length; i++) {
			newArraylist.add(myWords[i]);
		}
		//add the last value to the end of our arraylist
		newArraylist.add(last);
		//convert arraylist back to array
		String[] newArray = newArraylist.toArray(new String[myWords.length]);
		WordGram wg = new WordGram(newArray, 0, myWords.length);

		return wg;
	}

	/**
	 * Join our array of words (from source) into a singular String separated by " "
	 * @return the joined string
	 */
	@Override
	public String toString(){
		// TODO: Complete this method
		myToString = String.join(" ", myWords);
		return myToString;
	}
}
