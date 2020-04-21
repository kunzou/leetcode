import java.util.LinkedList;
import java.util.Queue;

public class LeetCode116 {
  public Node connect(Node root) {
    Queue<Node> queue = new LinkedList<>();

    Node result = new Node(root.val);
    Node cur = result;
    queue.add(root.left);
    queue.add(root.right);

    while(!queue.isEmpty()) {
      int size = queue.size();

      for(int i = 0; i < size; i++) {
        Node node = queue.poll();
        cur.next = new Node(node.val);
        cur = cur.next;
        if(node.left != null) {
          queue.add(node.left);
        }
        if(node.right != null) {
          queue.add(node.right);
        }
      }

    }
    return result;
  }
}


