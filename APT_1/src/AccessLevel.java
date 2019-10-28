//https://www2.cs.duke.edu/csed/newapt/accesslevel.html

public class AccessLevel {
    public String canAccess(int[] rights, int minPermission) {
        // fill in code here
        //each integer in the int array
        String returnString = "";
        for (int eachRight : rights) {
            if (eachRight >= minPermission) {
                returnString = returnString.concat("A");
            } else {
                returnString = returnString.concat("D");
            }
        }
        return returnString;
    }
}