public class DoubleList {
    public ListNode bigify(ListNode list) {
       //need to make sure we save what first is
       ListNode first = list;
        // if empty list just return null
        if (list == null) {
            return null;
        }
        while (list != null){
            //set temp to a new node equal to current
            ListNode temp = new ListNode(list.info);
            temp.next = list.next;
            list.next = temp;
            list = temp.next; //then set list to be the one that isn't double
        }


        return first;
    }
}

/**
 * Can also do the following in the while loop:
 * list.next = new Listnode(list.info, list.next);
 * list = list.next.next;
 */