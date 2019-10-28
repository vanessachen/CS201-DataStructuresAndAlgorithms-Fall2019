import java.util.HashMap;

public class Encryption {
    public String encrypt(String message){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        HashMap lettersCoded = new HashMap();
        int size = 0;
        for(int i=0; i<message.length(); i++){
            //each letter of the message
            char letter = message.charAt(i);
            //if our map does not contain that letter mapping, add it to our map
            if (!lettersCoded.containsKey(letter)){
                //put the letter and the alphabet letter it maps to into the Hashmap;
                //alphabet.charAt(size) with start at 'a'; size with increment once we have used
                lettersCoded.put(letter, alphabet.charAt(size));
                size += 1;
            }
        }
        //create char array of size message length
        char[] charArray = new char[message.length()];
        for(int j=0; j<message.length(); j++){
            //this will get the char the original letter maps to at index j
            charArray[j] = (char) lettersCoded.get(message.charAt(j));
        }
        String output = new String(charArray);
        return output;
    }
           public static void main(String[] args){
    	   Encryption en = new Encryption();
    	   String message1 = "hello";
    	   String test1 = en.encrypt(message1);
    	   System.out.println(test1);

    	   String message2 = "abcd";
    	   String test2 = en.encrypt(message2);
    	   System.out.println(test2);

    	   System.out.println(en.encrypt("topcoder"));
    }
}



/**
 public class Encryption {
 public String encrypt(String message){
 // you write code here
 //HashMap<String,Integer> encryption = new HashMap<String, Integer>();
 int[] messageCounts = getCounts(message);
 for (int i=97; i<=123; i++){
 if (messageCounts[i] >= 0){
 messageCounts[i] =
 }
 }
 return "";
 }
 private int[] getCounts(String string) {
 int[] counts = new int[300];
 //for each string in messages
 for (char ch : string.toCharArray()) {
 //counts how many of that character there is
 counts[ch] += 1;
 }
 return counts;
 }
 }
 */
