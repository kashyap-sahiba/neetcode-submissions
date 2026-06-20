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
    public boolean valid(TreeNode root, double left , double right){

        if(root == null)
        return true;

        if(!(left<root.val && root.val<right))
        return false;

        return valid(root.left,left,root.val) && valid(root.right,root.val,right);
        
    }
    public boolean isValidBST(TreeNode root) {
        
        return valid(root,Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY);
    }
}
