public class ListStretch {
    public ListNode stretch (ListNode list, int amount){
        //need to make sure we save what first is
        ListNode first = list;

        // if empty list just return null
        if (list == null) {
            return null;
        }

        while (list != null){
            for (int i=0; i<amount-1; i++) {
                ListNode current = list;
                //set temp to a new node equal to current's info, and it's next value equal to list.next
                ListNode temp = new ListNode(current.info, list.next);
                //
                list.next = temp;
                list = list.next; // list is now temp

            }
            //after all temps created, set temp.next to list .next

            list = list.next;

        }


        return first;
    }
}