/**
 * Resources Used:
 */

import java.util.*;

/**
 * Steps:
 * Loop through each info in String[] info
 * We don't care about the class so split info string by colon and keep not of classroom and meeting times (index 1 and 2)
 * Store classroom, times in hashmap
 *
 */

public class Conflicts {
    public String[] conflict(String[] info){
        // write code here
        HashMap<String,String> hashClassTime = new HashMap<String, String>();
        for (int i = 0; i < info.length; i++){
            String[] infoSplit = info[i].split(":");
            String classroom = infoSplit[1];
            String times = infoSplit[2];
            String[] eachTime = times.split(",");

            //put each classroom and corresponding time reserved into map
            for (int j = 0; j < eachTime.length; j++) {
                hashClassTime.put(classroom, eachTime[j]);
            }
        }
        //now check map for duplicate (times in) values
        //all of our times
        Collection<String> allTimes = hashClassTime.values();
        Set<String> setOfDuplicateClasses = new HashSet<>();

        for (String time : allTimes){
            //if str has occurred in allTimes more than once
            if (Collections.frequency(allTimes, time) > 1){
                for (String eachClass : hashClassTime.keySet()){
                    //if (hashClassTime.get(eachClass).equals(time)){
                        setOfDuplicateClasses.add(eachClass);
                    //}
                }
            }
        }
        //String[] finalClasses = (String[]) setOfDuplicateClasses.toArray();
        String[] finalClasses = new String[setOfDuplicateClasses.size()];
        finalClasses = setOfDuplicateClasses.toArray(finalClasses);

        return finalClasses;
    }
}
