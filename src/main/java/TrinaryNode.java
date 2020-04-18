public class TrinaryNode {
  int data;
  TrinaryNode left, right;
  TrinaryNode next;

  TrinaryNode(int value) {
    data = value;
    left = right = null;
    next = null;
  }

  public String toString() {
    return ""+data;
  }
} 