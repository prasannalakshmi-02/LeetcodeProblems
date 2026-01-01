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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        int depth = 0;
        helper(root, depth, list);
        return list;
    }
    public void helper(TreeNode node, int depth, List<Integer> list){
        if(node == null)return;
        if(list.size() == depth){
            list.add(node.val);
        }
        helper(node.right, depth+1, list);
        helper(node.left, depth+1, list);
    }
}