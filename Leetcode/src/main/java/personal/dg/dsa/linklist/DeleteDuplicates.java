package personal.dg.dsa.linklist;

public class DeleteDuplicates {


    public static void main(String[] args) {
        DeleteDuplicates d = new DeleteDuplicates();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        ListNode h = d.deleteDuplicates(head);
        System.out.println(h);
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null) {
            while (current.next != null && current.next.val == current.val) {
                ListNode tmp = current.next;
                current.next = current.next.next;
                tmp.next = null;
            }
            current = current.next;
        }

        return head;
    }

}
