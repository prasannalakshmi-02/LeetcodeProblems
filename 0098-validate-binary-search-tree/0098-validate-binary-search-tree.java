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
    private static Integer prev = null;
    public boolean isValidBST(TreeNode root) {
       prev = null;
       return inOrder(root);
    }

    public static boolean inOrder(TreeNode node){
        if(node == null)return true;
        if(!inOrder(node.left))return false;
        if(prev != null && node.val <= prev) return false;
        prev = node.val;
        return inOrder(node.right);
    }
}