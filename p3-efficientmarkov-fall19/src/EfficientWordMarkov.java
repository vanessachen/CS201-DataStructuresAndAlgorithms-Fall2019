import java.util.*;

public class EfficientWordMarkov extends BaseWordMarkov {
    private Map<WordGram,ArrayList<String>> myMap;

    /**
     * Initialize inherited state
     * Initialize instance variable myMap
     * @param order : the order of the markov model
     */
    public EfficientWordMarkov(int order)
    {
        super(order);
        myMap = new HashMap<WordGram, ArrayList<String>>();
    }


    /**
     * Calls other EfficientWordMarkov Constructor and Set order of markov model to 3
     */
    public EfficientWordMarkov()
    {
        this(3);
    }

    /**
     * Overview: Loop through the training text and create WordGrams of length myOrder,
     * find all strings that follow this WordGram in text, and add the key (WordGram) and value (strings that follow)
     * to the map.
     * Steps: Clear Map and set myText to param text
     * Iterate through the text and create all WordGrams of length myOrder
     * If not already in map, put WordGram in map with new arraylist
     * if at end of map, add PSEUDO_EOS to indicate end of string
     *
     * @param text : text to be analyzed
     */
    @Override
    public void setTraining(String text) {
        myMap.clear();//must clear map for getFollows to function correctly
        myMap = new HashMap<WordGram, ArrayList<String>>();
        myWords = text.split("\\s+");

        String next;
        //this loop allows us to iterate through all the substrings in the text (+1 because we want to include the last value
        for (int k = 0; k < myWords.length + 1 - myOrder; k++)
        {
            WordGram wordG = new WordGram(myWords, k, myOrder); //this is how to construct a wordgram from myWords, starting at k, of length myOrder
            if(!myMap.containsKey(wordG)) //substring not in map yet
                myMap.put(wordG,  new ArrayList<String>());//put substring in map and initialize new arraylist
            if(myOrder + k == myWords.length) //this is the last substring
                myMap.get(wordG).add(PSEUDO_EOS);
            else //key in list
            {
                next = myWords[k+myOrder];
                myMap.get(wordG).add(next); //add next to the values saved in key substring
            }
        }

    }

    /**
     * Look up key in markov map and return value : an Arraylist of strings created in setTraining
     * @param wordG : each WordGram (of length k) in the text being analyzed
     * @return an Arraylist of strings created in setTraining that follow key in the file
     */
    @Override
    public ArrayList<String> getFollows(WordGram wordG) {
        if (!myMap.containsKey(wordG))
            throw new NoSuchElementException(wordG+" not in map");
        return myMap.get(wordG);
    }
}
