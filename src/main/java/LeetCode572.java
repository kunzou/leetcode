import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LeetCode572 {
  public boolean isSubtree(TreeNode s, TreeNode t) {
    Queue<TreeNode> nodes = new ArrayDeque<>();
    nodes.add(s);
    while (!nodes.isEmpty()) {
      TreeNode node = nodes.poll();
      if (node.val == t.val && isSameTree(node, t)) {
        return true;
      }
      if (node.left != null) {
        nodes.add(node.left);
      }
      if (node.right != null) {
        nodes.add(node.right);
      }
    }
    return false;
  }

  public boolean isSameTree(TreeNode s, TreeNode t) {
    if (s == null && t == null) {
      return true;
    }
    if (s == null || t == null) {
      return false;
    }
    if (s.val != t.val) {
      return false;
    } else {
      return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
  }
}
