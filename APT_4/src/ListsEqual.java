
public class ListsEqual {
    public int equal (ListNode a1, ListNode a2) {
        //if one of them is null but not both of them are null
        if (((a1 == null) || (a2 == null)) && !(a1 == null && a2 == null)){
            return 0;
        }
        //while neither lists are null
        while ((a1 != null) && (a2 != null)){
            if (a1.info != a2.info) {
                return 0;
            }
            //shift
            a1 = a1.next;
            a2 = a2.next;
            //if one list is null, but they aren't both null
            if (((a1 == null) || (a2 == null)) && !(a1 == null && a2 == null)){
                return 0;
            }
            //if they aren't both null, check for same value
            if (!(a1 == null && a2 == null)) {
                //return 0;
                if ((a1.info != a2.info)) {
                    return 0;
                }
            }
        }
        return 1;
    }
}