import java.util.Optional;

public class Node {
  int val;
  Node next;
  Node random;

  public Node(int val) {
    this.val = val;
    this.next = null;
    this.random = null;
  }

  public void print() {
    Node cur = this;
    while(cur.next!=null) {
      System.out.print(String.format("%d(%s)->", cur.val, cur.random==null?"":cur.random.val));
      cur=cur.next;
    }
    System.out.println(String.format("%d(%s)", cur.val, cur.random==null?"":cur.random.val));
  }

  public Node coppyNode() {
    return new Node(val);
  }

  public Node addNode(int val) {
    Node cur = next;

    while(cur != null) {
      cur = cur.next;
    }
    next = new Node(val);
    return next;
  }

  public void setRandom(Node random) {
    this.random = random;
  }
}

