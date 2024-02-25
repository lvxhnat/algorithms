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
    public boolean isBalanced(TreeNode root) {
        return maxHeight(root) - minHeight(root) <= 1;
    }
    
    public int maxHeight(TreeNode node) {
        if (node == null) return 0;
        else return 1 + Math.max(height(node.left), height(node.right));
    }
    
    public int minHeight(TreeNode node) {
        if (node == null) return 0;
        else return 1 + Math.min(height(node.left), height(node.right));
    }
}
