public class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
  public void print() {
    ListNode cur = this;
    while(cur.next!=null) {
      System.out.print(cur.val+"->");
      cur=cur.next;
    }
    System.out.println(cur.val);
  }

  public ListNode addNode(int val) {
    ListNode cur = next;

    while(cur != null) {
      cur = cur.next;
    }
    next = new ListNode(val);
    return next;
  }
}