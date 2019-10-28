import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Resources Used:https://stackoverflow.com/questions/3064423/how-to-convert-an-array-to-a-set-in-java
 * https://javarevisited.blogspot.com/2015/12/how-to-split-comma-separated-string-in-java-example.html
 *
 */

public class UniqueNewYork {
    public int seen(String[] records) {
        /**Steps: for each record in string array records, split by comma to get another string[] of license plates.
         * Save each license plate array as a set to remove duplicates
         * count length of plate array and return that value
         */
        String[] plates = new String[records.length];
        Set<String> platesSet = new HashSet<>(Arrays.asList(plates));
        int numSeen = 0;
        for (int i = 0; i < records.length; i++){
           plates = records[i].split(",");
           platesSet.addAll(Arrays.asList(plates));
           //numSeen += platesSet.size();
        }
        numSeen = platesSet.size();
        //convert plates to set to remove dups
        //Set<String> platesSet = new HashSet<>(Arrays.asList(plates));


        return numSeen-1;
    }
}