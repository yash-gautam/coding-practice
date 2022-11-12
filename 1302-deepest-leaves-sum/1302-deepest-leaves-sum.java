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
    public int deepestLeavesSum(TreeNode root) {
        int height = findHeight(root);
        int sum = findSum(root, height);
        
        return sum;
    }
    
    public int findSum(TreeNode root, int height){
        
        if(root==null){
            return 0;
        }
        
        if(root.left==null && root.right==null){
            if(height==1){
                return root.val;
            } else{
                return 0;
            }
        }
        
        int ls = findSum(root.left, height-1);
        int rs = findSum(root.right, height-1);
        
        return ls+rs;
    }
    
    public int findHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        
        int lh = findHeight(root.left);
        int rh = findHeight(root.right);
        
        return 1+Math.max(lh, rh);
    }
}