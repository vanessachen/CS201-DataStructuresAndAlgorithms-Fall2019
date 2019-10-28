/**
 * Resources Used: <countFrequencies method, which I had written for the practice APT quiz> </countFrequencies>https://coursework.cs.duke.edu/vanessa.chen/cs201_datastructuresandalgorithms/blob/master/APTQuiz1_PracticeQuiz/src/MFreq.java
 * https://javadevnotes.com/java-split-string-into-arraylist-examples
 * https://stackoverflow.com/questions/2644637/how-to-lowercase-every-element-of-a-collection-efficiently
 */

import java.util.*;

/**
 * Steps: Split each string in String[] phrases by the space
 * Convert each item to lower case
 * add all of our strings to a compiled list of lower case words
 * Use countFrequencies method to find the frequency of each word in our compiled list
 */

public class Infrequent {
    public String find(String[] phrases){
        String minWord = "";
        List<String> phraseSplitListCompiled = new ArrayList<>();
        for (String phrase : phrases){
            String[] phraseSplit = phrase.split(" ");
            List<String> phraseSplitList = Arrays.asList(phraseSplit);
            //convert each item in our phraseSplitList to lowercase
            ListIterator<String> iterator = phraseSplitList.listIterator();
            while (iterator.hasNext())
            {
                iterator.set(iterator.next().toLowerCase());
            }

            // add all of our strings to a compiled list of lower case words
            for (String string : phraseSplitList){
                phraseSplitListCompiled.add(string);
            }

            //create hashmap to store frequency of each word
            HashMap <String,Integer> wordsFreqMap = countFrequencies((ArrayList<String>) phraseSplitListCompiled);

            int minCount = 51;

            /**
             * Find the value of the minimal occurring string(s)
             */
            //loop through each string (key) in wordsFreqMap
            for (String string : wordsFreqMap.keySet()){
                //if the frequency is less than maxCount
                if (wordsFreqMap.get(string) < minCount){
                    //set new min count equal to the value at that string
                    minCount = wordsFreqMap.get(string);
                    //set minWord equal to our current minimum string
                    minWord = string;
                }
            }

        }
        return minWord;
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