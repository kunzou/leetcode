import java.util.HashMap;
import java.util.Map;

public class LeetCode138 {

  public static NodeRamdom copyRandomList(NodeRamdom head) {
    NodeRamdom result = copyNode(head);
    NodeRamdom cur = result;
    Map<NodeRamdom, NodeRamdom> record = new HashMap<>();

    record.put(head, cur);

    if(head.random != null) {
      cur.random = head.random;
    }

    while(head.next != null) {
      cur.next = copyNode(head.next);
      record.put(head.next, cur.next);

      cur.next.random = head.next.random;

      head = head.next;
      cur = cur.next;
    }

    cur = result;

    while(cur.next != null) {
      if(cur.random != null) {
        cur.random = record.get(cur.random);
      }

      cur = cur.next;
    }

    if(cur.random != null) {
      cur.random = record.get(cur.random);
    }

    return result;
  }

  static NodeRamdom copyNode(NodeRamdom node) {
    return new NodeRamdom(node.val);
  }

  public static NodeRamdom copyRandomList_tooSlow(NodeRamdom head) {
    NodeRamdom result = copyNode(head);
    NodeRamdom cur = result;
    Map<Integer, NodeRamdom> record = new HashMap<>();

    record.put(result.val, result);

    if(head.random != null) {
      cur.random = copyNode(head.random);
      record.put(head.random.val, cur.random);
    }

    while(head.next != null) {
      if(record.containsKey(head.next.val)) {
        cur.next = record.get(head.next.val);
      }
      else {
        cur.next = copyNode(head.next);
        record.put(head.next.val, cur.next);
      }

      if(head.next.random != null) {
        if(!record.containsKey(head.next.random.val)) {
          cur.next.random = copyNode(head.next.random);
          record.put(head.next.random.val, cur.next.random);
        }
        else {
          cur.next.random = record.get(head.next.random.val);
        }
      }

      head = head.next;
      cur = cur.next;
    }
    return result;
  }
}


