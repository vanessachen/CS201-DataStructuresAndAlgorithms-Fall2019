/**
 * https://www2.cs.duke.edu/csed/newapt/sandwichbar.html
 */

/**
 * Constraints:
 * available will contain between 1 and 50 elements, inclusive.
 * Each element of available will contain between 1 and 50 lowercase letters ('a' - 'z'), inclusive.
 * orders will contain between 1 and 50 elements, inclusive.
 * Each element of orders will contain between 1 and 50 lowercase letters ('a' - 'z') and spaces, inclusive.
 * Each element of orders will represent a list of desired ingredients separated by single spaces, with no leading or trailing spaces.
 */

/**
 * Description:
 * The sandwich bar has certain ingredients available. I will list the types of sandwiches I like in order of preference and buy the first sandwich the bar can make for me. In order for the bar to make a sandwich for me, it must include all of the ingredients I desire.
 * Given a String[] available, a list of ingredients the sandwich bar can use, and a String[] orders, the types of sandwiches I like, in order of preference (most preferred first), return the 0-based index of the sandwich I will buy. Each element of orders represents one type of sandwich I like as a space-separated list of ingredients in the sandwich. If the bar can make no sandwiches I like, return -1.
 */

/**
 * available will contain between 1 and 50 elements, inclusive.
 * Each element of available will contain between 1 and 50 lowercase letters ('a' - 'z'), inclusive.
 * orders will contain between 1 and 50 elements, inclusive.
 * Each element of orders will contain between 1 and 50 lowercase letters ('a' - 'z') and spaces, inclusive.
 * Each element of orders will represent a list of desired ingredients separated by single spaces, with no leading or trailing spaces.
 */

import java.util.Arrays;

/**
 * try to start with code that runs
 */
public class SandwichBar {
    public int whichOrder(String[] available, String[] orders){
        //int w = -1;
        //int t = 0;
        //for every element in the orders (loop over every element in orders
        for (int a=0;a<orders.length;a++){
            String sandwich = orders[a]; // create a variable s of type String that is equal to the m'th index of the mth index of orders
            if (canMake(available,sandwich)){ //this means "if canMake is true"
                return a;
            }
            /**
            String[] wanted_Ingredients = sandwich.split(" "); // split the string called orders (by the spaces) into a StringArray to have a list of
            // ingredients that I want in my sandwich
            for (int b=0; b<available.length; b++){ //

            }
             */

        }
        //when you can't make the sandwich
        return -1;
    }

    //made this method private b/c it can only be accessed in SandwichBar class
    private boolean canMake(String[] available, String sandwich) {
        String[] all_ingredients = sandwich.split(" ");
        //for string in one -- all
        for (String one : all_ingredients){
            //if one is not in available; the power of APIs; arrays don't have helpful methods, but array lists do: so we are converting from an array to an array list
            if (!Arrays.asList(available).contains(one)){
                return false;
            }
        }
        return true;
    }

}
