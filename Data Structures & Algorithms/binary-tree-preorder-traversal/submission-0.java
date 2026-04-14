/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        
       List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;

        return inOrder(root, res);
    }

    List<Integer> inOrder(TreeNode root, List<Integer> res){
        if(root == null)
            return res;

        res.add(root.val);
        inOrder(root.left, res);        
        inOrder(root.right, res);

        return res;
    }
}