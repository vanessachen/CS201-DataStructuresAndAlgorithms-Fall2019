public class RemoveLast {
    public ListNode remove(ListNode list) {
        // replace statement below with code you write
        ListNode preLast = list; //begin with prelast being the first element in the name
        if ((preLast == null)||(preLast.next == null)){
            return null;
        }
        //if the element after the element after prelast isn't null
        while (preLast.next.next != null) {
            preLast = preLast.next; //move prelast to the one after it
        }
        preLast.next = null; //set prelast.next to nothing

        return list;
    }
}
