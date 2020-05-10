import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode23 {
  public ListNode mergeKLists(ListNode[] nodes) {
    PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
    ListNode result = new ListNode(0);
    for(ListNode node : nodes) {
      priorityQueue.add(node);
    }
    ListNode cur = result;
    while (!priorityQueue.isEmpty()) {
      ListNode node = priorityQueue.poll();
      cur.next = node;
      cur = cur.next;
      if(node.next != null) {
        priorityQueue.add(node.next);
      }
    }

    return result.next;
  }

/*  static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public int getVal() {
      return val;
    }
  }  */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

}
