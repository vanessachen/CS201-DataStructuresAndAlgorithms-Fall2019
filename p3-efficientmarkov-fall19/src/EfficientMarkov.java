import java.util.*;

public class EfficientMarkov extends BaseMarkov {
	private Map<String,ArrayList<String>> myMap;

	/**
	 * Initialize inherited state
	 * Initialize instance variable myMap
	 * @param order : the order of the markov model
	 */
	public EfficientMarkov(int order)
	{
		super(order);
		myMap = new HashMap<String, ArrayList<String>>();
	}

	/**
	 * Calls other EfficientMarkov Constructor and Set order of markov model to 3
	 */
	public EfficientMarkov()
	{
		this(3);
	}

	/**
	 * Overview: Loop through the training text and create substrings of length myOrder,
	 * find all characters that follow this substring in text, and add the key (substring) and value (characters that follow)
	 * to the map.
	 * Steps: Clear Map and set myText to param text
	 * Iterate through the text and create all substrings of length myOrder
	 * If not already in map, put substring in map with new arraylist
	 * if at end of map, add PSEUDO_EOS to indicate end of string
	 *
	 * @param text : text to be analyzed
	 */
	@Override
	public void setTraining(String text) {
		myMap.clear();//must clear map for getFollows to function correctly
		super.setTraining(text); //set myText to param text

		String substring;
		String next;
		//this loop allows us to iterate through all the substrings in the text (+1 because we want to include the last value
		for (int k = 0; k < myText.length() + 1 - myOrder; k++)
		{
			substring = myText.substring(k, myOrder + k); //create myOrder-character substrings from text
			//if substring not in map yet put substring in map and initialize new arraylist
			myMap.putIfAbsent(substring,  new ArrayList<String>());
			if(myOrder + k == myText.length()) //this is the last substring
				myMap.get(substring).add(PSEUDO_EOS);
			else {
				next = myText.substring(myOrder + k, myOrder + k + 1); //char after substring
				myMap.get(substring).add(next); //add next to the values saved in map for key substring
			}
		}
	}

	/**
	 * Look up key in markov map and return value : an Arraylist of single-character strings created in setTraining
	 * @param key : each substring (of length k) in the text being analyzed
	 * @return an Arraylist of single-character strings created in setTraining that follow key in the file
	 */
	@Override
	public ArrayList<String> getFollows(String key) {
		if (!myMap.containsKey(key))
			throw new NoSuchElementException(key+" not in map");
		return myMap.get(key);
	}
}	
