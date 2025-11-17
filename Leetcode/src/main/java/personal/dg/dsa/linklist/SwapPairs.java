package personal.dg.dsa.linklist;

public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode previous = dummy;
        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;
            first.next = second.next;
            second.next = first;
            previous.next = second;
            head = first.next;
            previous = first;
        }
        return dummy.next;
    }

}
