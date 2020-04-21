import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode103 {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if(root == null) {
      return new ArrayList<>();
    }

    Queue<TreeNode> queue = new LinkedList<>();
    List<List<Integer>> results = new ArrayList<>();

    queue.offer(root);
    boolean direction = true;
    while(!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> level = new ArrayList<>();
      for(int i = 0; i < size; i ++) {
        TreeNode cur = queue.poll();
        if(direction) {
          level.add(cur.val);
        }
        else {
          level.add(0, cur.val);
        }
        if(cur.left != null) {
          queue.add(cur.left);
        }
        if(cur.right != null) {
          queue.add(cur.right);
        }
      }
      results.add(level);
      direction = !direction;
    }

    System.out.println(results);

    return results;
  }
}
