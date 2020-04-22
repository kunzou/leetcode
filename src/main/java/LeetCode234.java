import java.util.LinkedList;

public class LeetCode234 {
  public boolean isPalindrome(ListNode head) {
    if(head == null || head.next == null) {
      return true;
    }

    LinkedList<Integer> integers = new LinkedList<>();

    while(head != null) {
      integers.add(head.val);
      head = head.next;
    }

    while(!integers.isEmpty()) {

      if(integers.size() == 1) {
        return true;
      }

      int in = integers.pollFirst();

      if(integers.isEmpty()) {
        return false;
      }
      int out = integers.pollLast();

      if(in != out) {
        return false;
      }
    }

    return true;
  }
}
