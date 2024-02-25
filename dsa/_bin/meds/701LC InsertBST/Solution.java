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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode current = root;
        if (current == null) {
            return new TreeNode(val);
        } else {
            while (true) {
                
                TreeNode parent = current; 
                
                if (current.val > val) {
                    current = current.left;
                    if (current == null) {
                        parent.left = new TreeNode(val);
                        return root;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = new TreeNode(val);
                        return root;
                    }
                }
            }
        }
    }
}
