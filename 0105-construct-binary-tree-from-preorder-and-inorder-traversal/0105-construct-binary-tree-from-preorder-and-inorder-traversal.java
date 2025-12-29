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
    private int preorderIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return build(preorder, 0, inorder.length-1, map);
    }

    public TreeNode build(int[] preorder, int left, int right, HashMap<Integer, Integer> map){
        if(left > right) return null;
        int rootValue = preorder[preorderIndex];
        TreeNode root = new TreeNode(rootValue);
        preorderIndex++;
        int splitIndex = map.get(rootValue);
        root.left = build(preorder, left, splitIndex-1, map);
        root.right = build(preorder, splitIndex+1, right, map);
        return root;
    }
}