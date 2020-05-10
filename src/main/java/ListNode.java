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

  public int getVal() {
    return val;
  }

  public ListNode addNode(int val) {
    next = new ListNode(val);
    return next;
  }
}