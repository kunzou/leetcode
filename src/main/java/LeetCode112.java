public class LeetCode112 {
  public boolean hasPathSum(TreeNode root, int sum) {
    if(root == null) {
      return false;
    }

    return hasPath(root, sum);
  }

  private boolean hasPath(TreeNode node, int sum) {
    sum = sum - node.val;
    if(node.left == null && node.right == null) {
      return sum == 0;
    }

    boolean result = false;
    if(node.left != null) {
      result = hasPath(node.left, sum);
    }
    if(node.right != null) {
      result = result || hasPath(node.right, sum);
    }

    return result;
  }

/*  private boolean hasPath(TreeNode node, int sum) {
    if(node == null) {
      return sum ==0;
    }

    return hasPath(node.left, sum - node.val) || hasPath(node.right, sum - node.val);
  }*/
}
