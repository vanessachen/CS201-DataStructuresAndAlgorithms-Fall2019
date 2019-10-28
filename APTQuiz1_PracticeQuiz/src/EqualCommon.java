/**
 * Resources: https://www.geeksforgeeks.org/operators-in-java/
 * https://stackoverflow.com/questions/1073919/how-to-convert-int-into-listinteger-in-java
 * https://stackoverflow.com/questions/8098601/java-count-occurrence-of-each-item-in-an-array
 * https://www.geeksforgeeks.org/treeset-in-java-with-examples/
 * https://www.techiedelight.com/convert-set-to-array-java/
 */

import java.util.*;

public class EqualCommon {
    public String[] matches(String[] a1, String[] a2) {
        // change this code
        /**
         * Steps: Count occurences of each string in string array a1 and a2 with for loops
         * save these
         */

        //because countFrequencies requires a List as a param, need to change my array to a list
        ArrayList<String> a1List = new ArrayList<>(Arrays.asList(a1));
        //each value in the list is stored with an integer representing its frequency
        HashMap <String,Integer> a1Map = countFrequencies(a1List);
        ArrayList<String> a2List = new ArrayList<>(Arrays.asList(a2));
        HashMap <String,Integer> a2Map = countFrequencies(a2List);

        //initialize list of common strings
        ArrayList<String> commonStrings = new ArrayList<>();

        //for each string in the a1Map set of keys
        for (String string : a1Map.keySet()) {
            //if a2Map also has that key (they share the same string)
            if (a2Map.containsKey(string)) {
                //if the shared string has the same value
                if(a1Map.get(string) == a2Map.get(string)) {
                    //add that string to our shared list of strings
                    commonStrings.add(string);
                }
            }
        }

       /**

        if (a1Map.size() < a2Map.size()) {
            for (String string : a1Map.keySet()) {
                if (a2Map.get(string).equals(a1Map.get(string))) {
                    commonStrings.add(string);
                }
            }
        }
        else {
            for (String string : a2Map.keySet()) {
                if (a1Map.get(string).equals(a2Map.get(string))) {
                    commonStrings.add(string);
                }
            }
        }
        TreeSet<String> commonStringsSet = new TreeSet<>(commonStrings);
        */
        //change our arraylist of common strings back to an array bc that's what the APT requires
        String[] commonStringsArray = commonStrings.toArray(new String[0]);
        Arrays.sort(commonStringsArray);
        return commonStringsArray;

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
    /**
    public int[] findFrequency(String[] stringArray){
        int[] occurrences = new int[stringArray.length];
        List stringList = Arrays.asList(stringArray);
        Set<String> stringSet = new HashSet<String>(stringList);
        for(String string : stringSet){
            List<Integer> occurrencesList = Arrays.asList(occurrences);
            occurrencesList.add(Collections.frequency(stringList,string));
        }
    }
     */
    /**
    public int[] count(String[] stringArray) {
        int[] occurrences = new int[stringArray.length];
        for(int i = 0; i < stringArray.length; i++){
            String temp = stringArray[i];
            occurrences[Integer.parseInt(temp)]++;
        }//end of for looop

        return occurrences;
    }
     */
}