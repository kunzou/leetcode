public class LeetCode543 {
  int max = Integer.MIN_VALUE;
  public int diameterOfBinaryTree(TreeNode root) {
    System.out.println(getDiameter(root));
    return max;
  }

  private int getDiameter(TreeNode node) {
    if(node == null) {
      return 0;
    }

    int left = getDiameter(node.left);
    int right = getDiameter(node.right);

    max = Math.max(max, left + right);

    return Math.max(left, right) + 1;
  }

}
