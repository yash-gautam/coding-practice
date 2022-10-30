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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        solve(root, list, "");
        return list;
    }
    
    public void solve(TreeNode root, List<String> list, String s){
        if(root==null){
            return;
        }
        
        if(root.left==null && root.right==null){
            list.add(s+root.val);
            return;
        }
        
        solve(root.left, list, s+root.val+"->");
        solve(root.right, list, s+root.val+"->");
    }
}