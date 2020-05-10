import java.util.*;
import java.util.stream.Collectors;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class LeetCode297 {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if(root == null) {
      return "";
    }

    Queue<TreeNode> treeNodes = new LinkedList<>();
    List<String> result = new ArrayList<>();
    treeNodes.add(root);
    while(!treeNodes.isEmpty()) {
      TreeNode treeNode = treeNodes.poll();
      if(treeNode != null) {
        result.add(String.valueOf(treeNode.val));
        treeNodes.add(treeNode.left);
        treeNodes.add(treeNode.right);
      }
      else {
        result.add("null");
      }
    }
    return String.join(",", result);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    TreeNode head;
    String[] nodes = data.split(",");

    if(nodes.length == 0 || nodes[0].equals("null")) {
      return null;
    }
    Queue<TreeNode> treeNodes = new LinkedList<>();
    int index = 0;
    head = new TreeNode(Integer.parseInt(nodes[index]));

    treeNodes.add(head);

    while(index < nodes.length) {
      TreeNode node = treeNodes.poll();
      index++;
      if(index < nodes.length && !"null".equals(nodes[index])) {
        node.addLeft(new TreeNode(Integer.parseInt(nodes[index])));
        treeNodes.add(node.left);
      }
      index++;
      if(index < nodes.length && !"null".equals(nodes[index])) {
        node.addRight(new TreeNode(Integer.parseInt(nodes[index])));
        treeNodes.add(node.right);
      }
    }
    return head;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));