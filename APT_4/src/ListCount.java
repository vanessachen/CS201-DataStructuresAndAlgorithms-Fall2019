public class ListCount {
    public int count (ListNode list) {
        // replace statement below with code you write
        int total = 0;
        while (list != null){
            total += 1;
            list = list.next;
        }
        return total;
    }
}
