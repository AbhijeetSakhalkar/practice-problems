package personal.dg.dsa.linklist;

public class MergeTwoSortedList {

    public static void main(String[] args) {
        MergeTwoSortedList m = new MergeTwoSortedList();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);
        ListNode ans = m.mergeTwoLists(l1,l2);
        System.out.println(ans);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(101);
        ListNode head = ans;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ListNode prev = l1;
                l1 = l1.next;
                prev.next = null;
                ans.next = prev;
            } else {
                ListNode prev = l2;
                l2 = l2.next;
                prev.next = null;
                ans.next = prev;
            }
            ans = ans.next;
        }
        if(l1 == null) {
            ans.next = l2;
        } else {
            ans.next = l1;
        }
        return head.next;
    }
}
