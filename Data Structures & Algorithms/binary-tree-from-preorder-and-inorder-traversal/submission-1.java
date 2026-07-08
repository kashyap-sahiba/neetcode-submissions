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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(preorder.length == 0) return null;

        return buildBrute(preorder, inorder, 0, 0, inorder.length-1);
    }

    public TreeNode buildBrute(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd){
        if(inStart > inEnd){
            return null;
        }

        int rootVal = preorder[preStart];

        TreeNode root = new TreeNode(rootVal);

        int rootPos = inStart;

        while(inorder[rootPos]!=rootVal){
            rootPos++;
        }

        int leftSize = rootPos - inStart;

        root.left = buildBrute(
            preorder,
            inorder,
            preStart+1,
            inStart,
            rootPos-1
        );

        root.right = buildBrute(
            preorder,
            inorder,
            preStart+1+leftSize,
            rootPos+1,
            inEnd
        );

        return root;
     }
}
