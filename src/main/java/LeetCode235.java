public class LeetCode235 {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    while((root.val> p.val && root.val>q.val) || (root.val<q.val && root.val<p.val)) {
      if(root.val> p.val && root.val>q.val) {
        root = root.left;
      }
      else {
        root = root.right;
      }
    }
    return root;
  }


  public TreeNode lowestCommonAncestorRecursive(TreeNode root, TreeNode p, TreeNode q) {

    if(p.val == root.val || q.val == root.val) {
      return root;
    }

    if(p.val < root.val && q.val < root.val) {
      return lowestCommonAncestorRecursive(root.left, p, q);
    } else if (p.val > root.val && q.val > root.val) {
      return lowestCommonAncestorRecursive(root.right, p, q);
    }

    return root;
  }


}
