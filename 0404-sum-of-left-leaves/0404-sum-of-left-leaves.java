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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null){
            return 0;
        }
        int ans = 0;        
        if(isLeaf(root.left)){
            ans+=root.left.val;
        } else{
            ans+=sumOfLeftLeaves(root.left);
        }
        
        ans+=sumOfLeftLeaves(root.right);
        
        return ans;
    }
    
    public boolean isLeaf(TreeNode root){
        if(root==null){
            return false;
        }
        return (root.left==null & root.right==null);
    }
}