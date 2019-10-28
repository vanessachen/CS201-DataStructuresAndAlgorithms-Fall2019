//https://www2.cs.duke.edu/csed/newapt/simplewordsearch.html

/**steps:
 * try saving our player string as a HashSet, to remove duplicates
 *
*/


import java.util.Arrays;
import java.util.HashSet;

public class SimpleWordGame {
    int score = 0;
    HashSet<String> scoreList = new HashSet<String>();
    public int points(String[] player,
                      String[] dictionary) {
        // you write code here
        // save player as a HashSet to remove duplicates
        HashSet<String> playerSet = new HashSet<>(Arrays.asList(player));
        HashSet<String> dictionarySet = new HashSet<>(Arrays.asList(dictionary));
        /**
        for (int k=0; k < dictionarySet.size(); k++){
            if (dictionarySet.contains(playerSet)){
                scoreList.add();
            }
        }
         */
        playerSet.retainAll(dictionarySet);
        //
        for (String word : playerSet ){
            score += word.length() * word.length();
        }
        return score;
    }
}