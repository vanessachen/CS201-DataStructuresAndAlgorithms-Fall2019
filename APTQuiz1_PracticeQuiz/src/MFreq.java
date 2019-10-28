/**
 * Used countFrequencies method from EqualCommon
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MFreq {
    public String[] frequent(String[] words){
        //because countFrequencies requires a List as a param, need to change my array to a list
        ArrayList<String> wordsList = new ArrayList<>(Arrays.asList(words));
        //each value in the list is stored with an integer representing its frequency
        HashMap <String,Integer> wordsFreqMap = countFrequencies(wordsList);

        int maxCount = 0;
        /**
         * Find the value of the maximal occurring string(s)
         */
        //loop through each string (key) in wordsFreqMap
        for (String string : wordsFreqMap.keySet()){
            //if the frequency is greater than maxCount
            if (wordsFreqMap.get(string) > maxCount){
                //set new max count equal to the value at that string
                maxCount = wordsFreqMap.get(string);
            }
        }

        ArrayList<String> maxWords = new ArrayList<>();
        /**
         * Save each key that has maxCount as value
         */
        for (String string : wordsFreqMap.keySet()){
            if (wordsFreqMap.get(string) == maxCount){
                maxWords.add(string);
            }
        }
        /**
         * Convert maxWords back to Array
         */
        String[] maxArray = maxWords.toArray(new String[0]);
        Arrays.sort(maxArray);

        return maxArray;
    }
    public HashMap<String,Integer> countFrequencies(ArrayList<String> list)
    {
        // hashmap to store the frequency of element
        Map<String, Integer> hashmap = new HashMap<String, Integer>();

        //for each string in the list
        for (String string : list) {
            Integer occurrences = hashmap.get(string); //integer j is the value associated with that string
            // if occurences (value) is null (we haven't assigned that string to a value yet, then set that it's occurred once.
            //otherwise, increase occurences by 1
            hashmap.put(string, (occurrences == null) ? 1 : occurrences + 1);
        }
        return (HashMap<String, Integer>) hashmap;
    }
}
