public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  public TreeNode(int val) {
    this.val = val;
  }

  public TreeNode addLeft(TreeNode left) {
    this.left = left;
    return this;
  }

  public TreeNode addRight(TreeNode right) {
    this.right = right;
    return this;
  }

  public String toString() {
    return String.valueOf(val);
  }

}
