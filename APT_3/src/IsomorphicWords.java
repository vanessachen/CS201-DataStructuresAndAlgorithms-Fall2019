import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsomorphicWords {
    public int countPairs(String[] words) {
        int isoWords = 0;
        //begin with outer loop, starting at index -
        for (int i = 0; i < words.length - 1; i++) {
            //first word will be first word in array words
            String word1 = iso(words[i]);
            //we will count in shifts where the we start with index 0 compared to index 1,2,.... then index 1 comparted to index 2,3,...
            for (int j = i + 1; j < words.length; j++) {
                //second word will begin as the second word in array words
                String word2 = iso(words[j]);

                if (word1.equals(word2)) {
                    isoWords += 1;
                }
            }
        }
        return isoWords;

    }

    public String iso(String message) {
        //String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String upperCaseMap = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        HashMap lettersCoded = new HashMap();
        int size = 0;
        for (int i = 0; i < message.length(); i++) {
            //each letter of the message
            char letter = message.charAt(i);
            //if our map does not contain that letter mapping, add it to our map
            if (!lettersCoded.containsKey(letter)) {
                //put the letter and the alphabet letter it maps to into the Hashmap;
                //alphabet.charAt(size) with start at 'a'; size with increment once we have used
                lettersCoded.put(letter, upperCaseMap.charAt(size));
                size += 1;
            }
        }
        //create char array of size message length
        char[] charArray = new char[message.length()];
        for (int j = 0; j < message.length(); j++) {
            //this will get the char the original letter maps to at index j
            charArray[j] = (char) lettersCoded.get(message.charAt(j));
        }
        String output = new String(charArray);
        return output;
    }
}
    /**
    public int countPairs(String[] words) {
        String[] encryptedString = new String[words.length];
        int numIsoWords = 0;
        for (int i = 0; i < words.length; i++) {
            //for each word in the string array, encrypt it and save it in the encryptedString
            encryptedString[i] = encrypt(words[i]);
        }
        Arrays.sort(encryptedString);
        for (int i = 0; i < encryptedString.length; ++i) {
            if (i + 1 == encryptedString.length) {
                numIsoWords += 0;
            } else if (encryptedString[i].equals(encryptedString[i + 1].hashCode())) {
                numIsoWords += 1;
            } else {
                numIsoWords += 0;
            }
        }
        return numIsoWords;
    }

    //use my encrypt method as a helper method
    public String encrypt(String message) {
        //String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String upperCaseMap = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        HashMap lettersCoded = new HashMap();
        int size = 0;
        for (int i = 0; i < message.length(); i++) {
            //each letter of the message
            char letter = message.charAt(i);
            //if our map does not contain that letter mapping, add it to our map
            if (!lettersCoded.containsKey(letter)) {
                //put the letter and the alphabet letter it maps to into the Hashmap;
                //alphabet.charAt(size) with start at 'a'; size with increment once we have used
                lettersCoded.put(letter, upperCaseMap.charAt(size));
                size += 1;
            }
        }
        //create char array of size message length
        char[] charArray = new char[message.length()];
        for (int j = 0; j < message.length(); j++) {
            //this will get the char the original letter maps to at index j
            charArray[j] = (char) lettersCoded.get(message.charAt(j));
        }
        String output = new String(charArray);
        return output;
    }
     */




        /**
        //create new hashmap for my encrypted String array
        Map<String,Integer> encryptedMap= new HashMap<String,Integer>();
        //for each encrypted word in the string
        for(String encryptedWord : encryptedString){
            //if the map has
            if(encryptedMap.containsKey(encryptedWord)) {
                encryptedMap.put(encryptedWord,encryptedMap.get(encryptedWord) + 1);
            }
            else {
                encryptedMap.put(encryptedWord, 1);
            }
        }
        for(int isoCount : encryptedMap.values()){
            if(isoCount > 1) {
                numIsoWords++;
            }
        }
         */
        /**
        //remove duplicates in encryptedString to find how many unique encryptions we have
        Arrays.sort(encryptedString);
        for (int j=0; j<encryptedString.length; j++){
            for (int k=1; k<encryptedString.length; k++){
                if(encryptedString[j]==encryptedString[k]){
                    numIsoWords += 1;
                }
            }
        }
        return numIsoWords;
         */



//when creating our isomorphic function, we will try to transform every inputted string to a new string: like xyzx becomes abca or ABCA
//try using capital letters to not get confused or try using numbers to differentiate
//try to find some kind of pattern for these strings; we want two isomorphic words to have the same output after running through the isomorphic function
