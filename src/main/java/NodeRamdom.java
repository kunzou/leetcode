public class NodeRamdom {
  int val;
  NodeRamdom next;
  NodeRamdom random;

  public NodeRamdom(int val) {
    this.val = val;
    this.next = null;
    this.random = null;
  }

  public void print() {
    NodeRamdom cur = this;
    while(cur.next!=null) {
      System.out.print(String.format("%d(%s)->", cur.val, cur.random==null?"":cur.random.val));
      cur=cur.next;
    }
    System.out.println(String.format("%d(%s)", cur.val, cur.random==null?"":cur.random.val));
  }

  public NodeRamdom coppyNode() {
    return new NodeRamdom(val);
  }

  public NodeRamdom addNode(int val) {
    NodeRamdom cur = next;

    while(cur != null) {
      cur = cur.next;
    }
    next = new NodeRamdom(val);
    return next;
  }

  public void setRandom(NodeRamdom random) {
    this.random = random;
  }
}

