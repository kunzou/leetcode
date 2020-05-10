public class LeetCode687 {
  int result;
  public int longestUnivaluePath(TreeNode root) {
    result = 0;
    arrowLength(root);
    return result;
  }
  public int arrowLength(TreeNode node) {
    if (node == null) {
      return 0;
    }
    int left = arrowLength(node.left);
    int right = arrowLength(node.right);
    int arrowLeft = 0;
    int arrowRight = 0;
    if (node.left != null && node.left.val == node.val) {
      arrowLeft += left + 1;
    }
    if (node.right != null && node.right.val == node.val) {
      arrowRight += right + 1;
    }
    result = Math.max(result, arrowLeft + arrowRight);
    return Math.max(arrowLeft, arrowRight);
  }
}


/*
  private int getDiameter(TreeNode node) {
    if(node == null) {
      return 0;
    }

    int left = getDiameter(node.left);
    int right = getDiameter(node.right);

    max = Math.max(max, left + right);

    return Math.max(left, right) + 1;
  }*/
