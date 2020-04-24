public class LeetCode21 {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode result = new ListNode(0);
    ListNode cur = result;

    while(l1 != null && l2!=null) {
      if(l1.val > l2.val) {
        cur.next = new ListNode(l2.val);
        l2 = l2.next;
      }
      else {
        cur.next = new ListNode(l1.val);
        l1 = l1.next;
      }
      cur = cur.next;
    }

    while(l1 != null) {
      cur.next = new ListNode(l1.val);
      l1 = l1.next;
      cur = cur.next;
    }

    while(l2 != null) {
      cur.next = new ListNode(l2.val);
      l2 = l2.next;
      cur = cur.next;
    }

    return result.next;
  }
}
