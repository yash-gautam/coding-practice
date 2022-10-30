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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return solve(root, targetSum, 0);
    }
    
    boolean solve(TreeNode root, int target, int sum){
        
        if(root==null){
            return false;
        }
        
        if( (root.left==null && root.right==null) ){
            sum+=root.val;
            if(sum==target) return true;
            else return  false;
        }
        
        return solve(root.left, target, sum+root.val) || 
               solve(root.right, target, sum+root.val);
        
    }
}