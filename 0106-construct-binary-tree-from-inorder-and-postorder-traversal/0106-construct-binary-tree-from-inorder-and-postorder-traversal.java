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
    private int postorderIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex = postorder.length-1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return build(postorder, 0, inorder.length-1, map);
       
    }
    public TreeNode build(int[] postorder, int left, int right, HashMap<Integer, Integer> map){
        if(right < left)return null;
        int rootValue = postorder[postorderIndex];
        TreeNode root = new TreeNode(rootValue);
        postorderIndex--;
        int splitIndex = map.get(rootValue);
        root.right = build(postorder, splitIndex+1, right, map);
        root.left = build(postorder, left, splitIndex-1, map);
        return root;
    }
}