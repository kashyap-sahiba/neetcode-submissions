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

        Map<Integer,Integer> inorderMap = new HashMap<>();

        for(int i=0; i < inorder.length; i++){
            inorderMap.put(inorder[i],i);
        }

        return buildBrute(preorder, inorderMap, 0, 0, inorder.length-1);
    }

    public TreeNode buildBrute(int[] preorder, Map<Integer,Integer> inorderMap, int preStart, int inStart, int inEnd){
        if(inStart > inEnd){
            return null;
        }

        int rootVal = preorder[preStart];

        TreeNode root = new TreeNode(rootVal);

        int rootPos = inorderMap.get(rootVal);

        int leftSize = rootPos - inStart;

        root.left = buildBrute(
            preorder,
            inorderMap,
            preStart+1,
            inStart,
            rootPos-1
        );

        root.right = buildBrute(
            preorder,
            inorderMap,
            preStart+1+leftSize,
            rootPos+1,
            inEnd
        );

        return root;
     }
}
