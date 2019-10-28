//https://www2.cs.duke.edu/csed/newapt/starter.html

import java.util.Arrays;
import java.util.HashSet;

public class Starter {
    public int begins(String[] words, String first) {
        int numMatches = 0;
        //remove the duplicates in a word by saving it as a Hashset
        HashSet<String> wordsSet = new HashSet<>(Arrays.asList(words));
        // loop over each word in the Set of words
        for (String word : wordsSet){
            //the first character in the word
            char firstChar = word.charAt(0);
            if (firstChar == first.charAt(0)){
                numMatches += 1;
            }
        }
        return numMatches;
    }
}