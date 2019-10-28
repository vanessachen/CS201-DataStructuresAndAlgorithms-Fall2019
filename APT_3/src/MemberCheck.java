import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MemberCheck {
    public String[] whosDishonest(String[] club1,
                                  String[] club2,
                                  String[] club3) {
        // TODO: fill in code here
        Set<String> result = new HashSet<>();
        Set<String> s1 = new HashSet<>(Arrays.asList(club1));
        Set<String> s2 = new HashSet<>(Arrays.asList(club2));
        Set<String> s3 = new HashSet<>(Arrays.asList(club3));

        //add the results from the "intersection" method to see where the strings intersect
        result.addAll(intersection(s1,s2));
        result.addAll(intersection(s1,s3));
        result.addAll(intersection(s2,s3));
        String[] ret = result.toArray(new String[0]);
        //we want the sorted array
        Arrays.sort(ret);
        return ret;
    }

    private Set<String> intersection(Set<String> string1, Set<String> string2){
        HashSet<String> string1Copy= new HashSet<>(string1);
        HashSet<String> string2Copy= new HashSet<>(string2);
        string1Copy.retainAll(string2Copy); // string1 now contains only elements in both sets
        return string1Copy;
        //we want to make a copy of the Set before we do .retainAll() bc it affects the original set
    }

}