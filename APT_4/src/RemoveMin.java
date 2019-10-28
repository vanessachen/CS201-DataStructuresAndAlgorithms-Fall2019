public class RemoveMin {
    public ListNode remove (ListNode list) {

        ListNode first = list;
        //if list null or only one element
        if ((list == null)||(list.next == null)){
            return null;
        }
        int min = findMin(list);

        // if min value is first node
        if ((list.next != null) && (list.info == min)){
            //create new listnode
            ListNode replacement = new ListNode(list.next.info, list.next.next);
            return replacement; //replacement becomes the new first value
        }

        while (list != null) {
            if ((list.next.next != null) && (list.next.info == min)){// min is somewhere in list
                list.next = list.next.next;
                return first;
            }
            else if ((list.next.next == null) && (list.info != min)) {    // min is last node
                list.next = null;
                return first;
            }
            list = list.next;
        }

        return first;
    }
    public int findMin (ListNode list){
        int min = list.info;//set min to current node's info
        while (list != null) {
            ListNode current = list;
            if (min > current.info){
                min = current.info;
            }
            list = list.next;

        }
        return min;
    }

}