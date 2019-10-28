
import java.util.Arrays;
import java.util.HashMap;

public class Anonymous {
    public int howMany(String[] headlines, String[] messages) {
        // fill in code here
        int[] headlineCounts = getCounts(headlines);
        //int[] messagesCounts = getCounts(messages);
        int possibleWordsMade = 0;
        for (String message : messages) {
            String[] oneMessage = {message};
            int[] lettersNeeded = getCounts(oneMessage);
            //int temporaryLetterCounter = 0;
            boolean continueCounting = true;
            //97 to 123 is for lower case letters
            for (int i = 97; i <= 123; i++) {
                //System.out.println(headlineCounts[]);
                if (i == 123) {
                    possibleWordsMade += 1;
                } else if ((headlineCounts[i] < lettersNeeded[i])) {
                    continueCounting = false;
                    break;
                }
            }
        }
        return possibleWordsMade;
    }

    private int[] getCounts(String[] strings) {
        int[] counts = new int[300];
        //for each string in messages
        for (String s : strings) {
            //for each character in the string, convert to lowercase CharArray
            for (char ch : s.toLowerCase().toCharArray()) {
                //counts how many of that character there is
                counts[ch] += 1;
            }
        }
        return counts;
    }
}
/**
    public static void main(String[] args ){
        Anonymous a = new Anonymous();
        String[] headlines = {"Earthquake in San Francisco", "Burglary at musuem in Sweden", "Poverty"};
        String[] messages = {"Give me my money back", "I am the best coder", "TOPCODER"};

        System.out.println(a.howMany(headlines, messages));
    }
}
 */

/**
public class Anonymous {
    public int howMany(String[] headlines, String[] messages) {
        // fill in code here
        int[] headlineCounts = getCounts(headlines);
        //int[] messagesCounts = getCounts(messages);
        int possibleWordsMade = 0;
        for (String message : messages){
            String[] oneMessage = {message};
            int[] lettersNeeded = getCounts(oneMessage);
            int temporaryLetterCounter = 0;
            boolean startedCounting = false;
            for (int i : lettersNeeded) {
                //System.out.println("in for loop 2");
                if ((headlineCounts[i] >= lettersNeeded[i]) && (lettersNeeded[i] > 0)) {
                    System.out.println("in if statement 1");
                    startedCounting = true;
                    headlineCounts[i] -= 1;
                    lettersNeeded[i] -= 1;
                }
                if (lettersNeeded[i]==0){
                    temporaryLetterCounter += 1;
                }
                if ((startedCounting == true) && (temporaryLetterCounter == lettersNeeded.length)){
                    possibleWordsMade += 1;

                }
            }
        }
        return possibleWordsMade;
    }
    private int[] getCounts(String[] strings){
        int[] counts = new int[300];
        //for each string in messages
        for (String s: strings){
            //for each character in the string, convert to lowercase CharArray
            for (char ch: s.toLowerCase().toCharArray()){
                //counts how many of that character there is
                counts[ch] += 1;
            }
        }
        return counts;
    }

    public static void main(String[] args ){
        Anonymous a = new Anonymous();
        String[] headlines = {"Earthquake in San Francisco", "Burglary at musuem in Sweden", "Poverty"};
        String[] messages = {"Give me my money back", "I am the best coder", "TOPCODER"};
        a.howMany(headlines, messages);
    }
}
 */



/**

import java.util.*;

public class Anonymous {
    public int howMany(String[] headlines, String[] messages) {

        // count how many of each letter available
        HashMap<Character, Integer> lettersAvailable = countLetters(headlines);
//    	  System.out.println(lettersAvailable);

        // see how many words we can make
        int wordsCanMake = 0;
        for(String message : messages){
            String[] oneMessage = {message};
            HashMap<Character, Integer> lettersNeeded = countLetters(oneMessage);
            boolean canMakeMessage = true;
            Iterator it = lettersNeeded.entrySet().iterator();
            while (it.hasNext()){
                Map.Entry pairs = (Map.Entry)it.next();
                char key = (Character) pairs.getKey();
                if(!(key==' ')){
                    int numNeeded = (Integer) pairs.getValue();
                    if(lettersAvailable.containsKey(key)){
                        int numAvailable = lettersAvailable.get(key);
                        canMakeMessage = (numNeeded <= numAvailable) && canMakeMessage;
                    }
                    else{
                        canMakeMessage = false ;
                        break;
                    }
                }

                it.remove();
            }
            if(canMakeMessage){
                wordsCanMake += 1;
            }
        }
        return wordsCanMake;
    }

    public HashMap<Character, Integer> countLetters(String[] words){
        HashMap<Character, Integer> counts = new HashMap<Character, Integer>();
        int currentCountOfLetter = 0;

        for(String word : words){
            for(int i=0; i<word.length(); i++){
                //letter is the lowercase letter of the word at the i'th indez
                char letter = Character.toLowerCase(word.charAt(i));
                //https://www.geeksforgeeks.org/hashmap-containskey-method-in-java/
                // check whether a particular key is being mapped into the HashMap or not. It takes the key element as a parameter and returns True if that element is mapped in the map.
                if (counts.containsKey(letter)){
                    //.get() used to retrieve or fetch the value mapped by a particular key mentioned in the parameter
                    currentCountOfLetter = counts.get(letter);
                    currentCountOfLetter +=1;
                }
                else {
                    currentCountOfLetter = 1;
                }
                //
                counts.put(letter, currentCountOfLetter);
            }
        }

        return counts;
    }

      public static void main(String[] args){
    	  Anonymous a = new Anonymous();
    	  String[] h1 = {"Earthquake in San Francisco", "Burglary at musuem in Sweden", "Poverty"};
    	  String[] m1 = {"Give me my money back", "I am the best coder", "TOPCODER"};
    	  int test1 = a.howMany(h1, m1);
    	  System.out.println(test1); // 2

    	  String[] h2 = {"j "};
    	  String[] m2 = {"hva w ", " IQHmks k FP jR yd "};
       	  System.out.println(a.howMany(h2, m2)); // 0
      }
}
 */