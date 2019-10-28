public class AddSome {
    public ListNode splice(ListNode list, int size){

        ListNode first = list;
        while (list != null){
            int sizeCounter = 0;
            if (sizeCounter < size){
                ListNode currentAdd = new ListNode(list.info, list.next);
                list.next = currentAdd;
                list = list.next;
            }
            if (sizeCounter >= size){
                list.next = 
            }
            sizeCounter++;


        }

        return first;
    }
}