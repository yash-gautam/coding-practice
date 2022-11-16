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
    int leftNode = 0;
    int maxDepth = 0;
    
    public int findBottomLeftValue(TreeNode root) {
        solve(root, 1);
        return leftNode;
    }
    
    public void solve(TreeNode root, int depth){
        if(root==null){
            return;
        }
        
        if(depth>maxDepth){
            maxDepth = depth;
            leftNode = root.val;
        }
        
        solve(root.left, depth+1);
        solve(root.right, depth+1);
        
    }
    
    
//     public int findBottomLeftValue(TreeNode root) {
//         Queue<TreeNode> q = new LinkedList<>();
//         q.offer(root);
        
//         int leftNode = -1;
//         while(!q.isEmpty()){
//             int size = q.size();
//             for(int i=0; i<size; i++){
//                 TreeNode node = q.poll();
//                 if(node.right!=null){
//                     q.offer(node.right);
//                 }
//                 if(node.left!=null){
//                     q.offer(node.left);
//                 }
                
//                 leftNode = node.val;
//             }
//         }
        
//         return leftNode;
//     }
}