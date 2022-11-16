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
    public int findBottomLeftValue(TreeNode root) {
        int[] max = new int[]{0, 0};
        solve(root, 1, max);
        return max[1];
    }
    
    public void solve(TreeNode root, int depth, int[] max){
        if(root==null){
            return;
        }
        
        if(depth>max[0]){
            max[0] = depth;
            max[1] = root.val;
        }
        
        solve(root.left, depth+1, max);
        solve(root.right, depth+1, max);
        
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