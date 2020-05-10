public class LeetCode124 {
  int max = Integer.MIN_VALUE;
  public int maxPathSum(TreeNode root) {
    getMax(root);
    return max;
  }

  private int getMax(TreeNode node) {
    if(node == null) {
      return 0;
    }

    int left = Math.max(Integer.MIN_VALUE, getMax(node.left));
    int right = Math.max(Integer.MIN_VALUE, getMax(node.right));
    int sum = left + right + node.val;
    max = Math.max(max, sum);
    return Math.max(left, right) + node.val;
  }
}
