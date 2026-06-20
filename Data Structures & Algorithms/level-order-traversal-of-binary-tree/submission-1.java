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

    Map<Integer,List<Integer>> levels = new HashMap<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        
        if(root == null) return new ArrayList<>();

        dfs(0,root);

        List<List<Integer>> result = new ArrayList<>();
        int depth=0;

        while(levels.containsKey(depth)){
            result.add(levels.get(depth));
            depth++;
        }

        return result;
    }

    public void dfs(int depth,TreeNode node){
        if(node==null) return;

        levels.computeIfAbsent(depth,k->new ArrayList<>()).add(node.val);

        dfs(depth+1,node.left);
        dfs(depth+1,node.right);
    }
}
