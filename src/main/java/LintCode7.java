import java.util.LinkedList;
import java.util.Queue;

/**

 Definition of TreeNode:
 public class TreeNode {
 public int val;
 public TreeNode left, right;
 public TreeNode(int val) {
 this.val = val;
 this.left = this.right = null;
 }
 }
 */
public class LintCode7 {
  /**
   * This method will be invoked first, you should design your own algorithm
   * to serialize a binary tree which denote by a root node to a string which
   * can be easily deserialized by your own "deserialize" method later.
   */
  public String serialize(TreeNode root) {
// write your code here
    String res="{";
    if (root==null){
      return res+"}";
    }
    res+=root.val+",";
    Queue<TreeNode> queue= new LinkedList();
    queue.offer(root);
    TreeNode head;
    while(!queue.isEmpty()){
      head= queue.poll();
      if(head.left!=null){
        res +=(head.left.val+",");
        queue.offer(head.left);
      }else{
        res+="#,";
      }

      if(head.right!=null){
        res +=(head.right.val+",");
        queue.offer(head.right);
      }else{
        res+="#,";
      }
    }
    return res;
  }

  /**
   * This method will be invoked second, the argument data is what exactly
   * you serialized at method "serialize", that means the data is not given by
   * system, it's given by your own serialize method. So the format of data is
   * designed by yourself, and deserialize it here as you serialize it in
   * "serialize" method.
   */
  public TreeNode deserialize(String data) {
    // write your code here
    if("{}".equals(data)){
      return null;
    }
    int index=0;
    String[] temp = data.substring(1, data.length() - 1).split(",");
    TreeNode head = generateTreeNode(temp[index++]);
    if (head == null) {
      return null;
    }
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    q.offer(head);
    while(!q.isEmpty()) {
      TreeNode tempNode = q.poll();
      tempNode.left = generateTreeNode(temp[index++]);
      tempNode.right = generateTreeNode(temp[index++]);
      if(tempNode.left!=null) {
        q.offer(tempNode.left);
      }
      if(tempNode.right!=null) {
        q.offer(tempNode.right);
      }
    }
    return head;
  }

  public TreeNode generateTreeNode(String value){
    if("#".equals(value)){
      return null;
    } else {
      return new TreeNode(Integer.valueOf(value));
    }
  }
}