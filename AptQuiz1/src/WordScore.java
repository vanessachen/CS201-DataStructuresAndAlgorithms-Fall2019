/**
 * Resources Used:https://stackoverflow.com/questions/15331637/convert-string-to-arraylist-character-in-java
 * https://www.java-examples.com/java-string-array-list-example
 */

import java.util.*;

/**
 * Steps:
 * Convert each word in String[] words to a char array
 * //remove duplicates in my char array from words
 * Loop through each character in word and see if in String wants.
 *     - for each occurence in string wants, add 1 to score of word
 * Loop through each character in word and see if in String avoid.
 *     - for each occurence in string avoid, subtract 1 to score of word
 * Now add each word's score to the int array of scores.
 */

public class WordScore {
    public int[] score(String[] words, String want, String avoid) {
        int[] scores = new int[words.length];

        String[] wantArray = want.split("(?!^)");
        //char[] wantChar = want.toCharArray();
        //ArrayList<String> wantList = (ArrayList<String>) Arrays.asList(wantArray);
        ArrayList<String> wantList = new ArrayList<>();
        Collections.addAll(wantList,wantArray);

        String[] avoidArray = avoid.split("(?!^)");
        //ArrayList<String> avoidList = (ArrayList<String>) Arrays.asList(avoidArray);
        ArrayList<String> avoidList = new ArrayList<>();
        Collections.addAll(avoidList,avoidArray);

        //now that everything is an arrayList, we can use .contains method
        for (int i = 0; i < words.length; i++){
            //split word into String[] of characters
            String[] wordArray = words[i].split("(?!^)");

            for (int k = 0; k < wordArray.length; k++){
                if (wantList.contains(wordArray[k])){
                    scores[i] += 1;
                }
            }

            for (int k = 0; k < wordArray.length; k++){
                if (avoidList.contains(wordArray[k])){
                    scores[i] -= 1;
                }
            }
        }

        //char[] avoidChar = avoid.toCharArray();

        //for each word in String[] words
        /**
        for (int j = 0; j < words.length; j++){

            char[] chars = words[j].toCharArray();

            //for each character in the word
            for (int i = 0; i < chars.length; i++){
                //check if character in want string
                for (int k = 0; k < wantChar.length; k++){
                    if (chars[i] == wantChar[k]){
                        scores[j] = (scores[j]+1);
                    }
                }
                //check in character in avoid string
                for (int k = 0; k < avoidChar.length; k++){
                    if (chars[i] == avoidChar[k]){
                        scores[j] = (scores[j]-1);
                    }
                }
            }
        }
         */

        return scores;
    }
}