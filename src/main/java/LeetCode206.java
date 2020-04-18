public class LeetCode206 {
  public static ListNode reverseList(ListNode head) {
    ListNode nxt;
    ListNode cur = head;
    nxt = cur.next;
    cur.next = null;
    ListNode temp;
    while(nxt != null) {
      temp = nxt.next;
      nxt.next = cur;
      cur = nxt;
      nxt = temp;
    }

    return cur;
  }

  public static ListNode reverseListRecursively(ListNode head) {
    if(head == null || head.next == null) {
      return head;
    }

    ListNode cur = reverseListRecursively(head.next);
    head.next.next = head;
    head.next = null;

    return cur;
  }

}


//Input: 1->2->3->4->5->NULL
//Output: 5->4->3->2->1->NULL