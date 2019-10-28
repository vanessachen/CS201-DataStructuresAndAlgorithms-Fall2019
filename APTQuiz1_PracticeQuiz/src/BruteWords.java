import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Steps:
 * Split str into a String[] of each character as a string; used :https://stackoverflow.com/questions/5235401/split-string-into-array-of-character-strings
 * Use method countFrequency from EqualCommon to map each char string to a value that records how many times it occurs in the str
 * Calculate the score of original str
 * Write for loop to brute force check each replacement possibility and calculate the score of that
 */


public class BruteWords {
    public int getScore(String str){
        //save str as a string array with each char as a string
        String[] strArray = str.split("(?!^)");
        //because countFrequencies requires a List as a param, need to change my array to a list
        ArrayList<String> strList = new ArrayList<>(Arrays.asList(strArray));
        //each value in the list is stored with an integer representing its frequency
        HashMap <String,Integer> strFreqMap = countFrequencies(strList);

        int initialScore = calcScore(strFreqMap);
        String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("(?!^)");
        int tempScore = 0;
        int finalScore = 0;
        for (int k = 0; k < strArray.length; k++){

            String strOfKOriginal = strArray[k];
            for (int i = 0; i < 26; i++) {
                //save the original value
                String tempString = str.replace(strOfKOriginal,alphabet[i]);


                String[] strArrayTemp = tempString.split("(?!^)");
                ArrayList<String> strListTemp = new ArrayList<>(Arrays.asList(strArrayTemp));
                HashMap <String,Integer> strFreqMapTemp = countFrequencies(strListTemp);
                tempScore = calcScore(strFreqMapTemp);

                if (tempScore > finalScore){
                    finalScore = tempScore;
                }
                //else {
                    //finalScore = initialScore;
                //}
                //set that changed letter back to normal
                //strArray[k] = strOfKOriginal;
                //strArray = str.split("(?!^)");

            }
            //strArray = str.split("(?!^)");
        }
        // replace with your code
        return finalScore;
    }
    public int calcScore(HashMap<String,Integer> strFreqMap){
        int score = 0;
        for(String string : strFreqMap.keySet()){
            //for each string (which is a character) in str, add the square of the frequency of the char to score
            score += (strFreqMap.get(string)*strFreqMap.get(string));

        }
        return score;
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