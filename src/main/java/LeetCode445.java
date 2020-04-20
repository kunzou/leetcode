import java.util.Stack;

public class LeetCode445 {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    ListNode result = new ListNode(-1);
    ListNode current;
    int sum;
    int carry = 0;

    while(l1 != null) {
      stack1.push(l1.val);
      l1 = l1.next;
    }

    while(l2 != null) {
      stack2.push(l2.val);
      l2 = l2.next;
    }

    while(!stack1.isEmpty() && !stack2.isEmpty()) {
      sum = stack1.pop() + stack2.pop() + carry;
      carry = sum /10;
      sum = sum % 10;

      current = new ListNode(sum);
      current.next = result.next;
      result.next = current;
    }

    while(!stack1.isEmpty()) {
      sum = carry + stack1.pop();
      carry = sum /10;
      sum = sum % 10;

      current = new ListNode(sum);
      current.next = result.next;
      result.next = current;
    }

    while(!stack2.isEmpty()) {
      sum = carry + stack2.pop();
      carry = sum /10;
      sum = sum % 10;

      current = new ListNode(sum);
      current.next = result.next;
      result.next = current;
    }

    if(carry == 1) {
      current = new ListNode(1);
      current.next = result.next;
      result.next = current;
    }
    return result.next;
  }

}
