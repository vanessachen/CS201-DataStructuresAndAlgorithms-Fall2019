public class ListLastFirst {
    public ListNode move(ListNode list) {

        // if only one node in list, return that node
        if ((list == null)||(list.next == null)){
            return list;
        }
        // we want the first node in original list to be second node in our new list
        ListNode firstOG = new ListNode(list.info, list.next);

        while (list.next.next != null){
            list = list.next;
            if (list.next.next==null) { //we are at second to last node
                //this is the new first, with info equal to the last node
                ListNode first = new ListNode(list.next.info, firstOG); // makes .next of last node be firstOG
                list.next = null;       // second to last node is now last node bc .next is null
                return first;           // returns a linked list with last node now first node
            }
            //list = list.next;
        }
        return list;
    }
}

/**
 *    public ListNode move(ListNode list) {
 *
 *         // if only one node in list, return that node
 *         if ((list == null)||(list.next == null)){
 *             return list;
 *         }
 *        // ListNode firstOG = list;
 *         ListNode temp = list;
 *         while (list.next != null){
 *            // temp.next = firstOG;
 *            // firstOG.next = list;
 *             //list.next = temp;
 *             temp.next = list;
 *             list = list.next;
 *             if (list.next==null) {
 *                 temp.info = list.info;
 *                 //list =
 *                 //first = second;
 *                 //list.next = null;
 *             }
 *         }
 *         return temp;
 *     }
 */