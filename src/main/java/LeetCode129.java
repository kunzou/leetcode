import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LeetCode129 {
  public int sumNumbers(TreeNode root) {
    if(root == null) {
      return 0;
    }
    List<Integer> numbers = new ArrayList<>();

    getAllNumbers(root, numbers, 0);
    return numbers.stream()
        .reduce(0, (a, b) -> a + b);
//    int sum = 0;
//    for(int i : numbers) {
//      sum+=i;
//    }
//    return sum;
  }

  void getAllNumbers(TreeNode node, List<Integer> numbers, int prev) {
    if(node.left == null && node.right == null) {
      numbers.add(prev*10+node.val);
      return;
    }
    if(node.left != null) {
      getAllNumbers(node.left, numbers, prev*10+node.val);
    }
    if(node.right != null) {
      getAllNumbers(node.right, numbers, prev*10+node.val);
    }
  }
}
