/**
 * Resources Used:
 *
 */

import java.util.Arrays;
import java.util.List;

/**
 * Steps: Loop through each item in word and check if in dictionary
 *      - do this by changing dictionary to an arrayList to use .contains method
 * if word not in dictionary, add to misspelledWords
 */
public class Misspelled {
    public int howMany(String[] words, String[] dictionary) {
        // write code here
        int misspelledWords = 0;

        //convert both string[] to list to use .contains
        //List<String> wordsList = Arrays.asList(words);
        List<String> dictionaryList = Arrays.asList(dictionary);
        //loop through each word
        for (int i = 0; i < words.length; i++){
            if (!dictionaryList.contains(words[i])){
                misspelledWords += 1;
            }


            /**
            //loop through each word in dictionary
            for (int k = 0; k < dictionary.length; k++) {
                //if word is in dictionary
                if (words[i]==dictionary[k]){
                    break;
                }
                else if (k == dictionary.length-1) {
                    misspelledWords += 1;
                }
            }
             */
        }


        return misspelledWords;
    }
}
