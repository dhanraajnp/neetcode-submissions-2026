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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> que = new LinkedList<>();
        
        if(root == null)
            return res;

        que.offer(root);
        boolean flip = false;
        
        while(!que.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = que.size();
            for(int i=0; i<size; i++){                
                if(flip){
                    TreeNode curr = que.pollLast();
                    level.add(curr.val);
                    if(curr.right != null)
                        que.addFirst(curr.right);
                    if(curr.left != null)
                        que.addFirst(curr.left);                
                } else {
                    TreeNode curr = que.pollFirst();
                    level.add(curr.val);
                    if(curr.left != null)
                        que.addLast(curr.left);
                    if(curr.right != null)
                        que.addLast(curr.right);                    
                }
            }
            res.add(level);
            flip = !flip;
        }

        return res;
    }
}