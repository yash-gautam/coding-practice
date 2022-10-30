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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        solve(root, targetSum, list, new ArrayList<>());
        return list;
    }
    
    void solve(TreeNode root, int target, List<List<Integer>> list, List<Integer> temp){
        if(root==null){
            return;
        }
        
        temp.add(root.val);
        
        if(root.left==null && root.right==null){
            if(target==root.val){
                // temp.add(root.val);
                list.add(new ArrayList<>(temp));
            }
            return;
        }
        
        if(root.left!=null){
            solve(root.left, target-root.val, list, temp);
            temp.remove(temp.size()-1);
        }
        if(root.right!=null){
            solve(root.right, target-root.val, list, temp);
            temp.remove(temp.size()-1);
        }
    }
}