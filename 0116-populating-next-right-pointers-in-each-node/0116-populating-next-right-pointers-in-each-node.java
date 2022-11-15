/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
//     public Node connect(Node root) {
//         if(root==null){
//             return root; 
//         }
        
//         Queue<Node> q = new LinkedList<>();
//         q.offer(root);
        
//         while(!q.isEmpty()){
//             int size = q.size();
//             for(int i=0; i<size; i++){
//                 Node node = q.poll();
//                 if(i==size-1){
//                     node.next = null;
//                 } else{
//                     node.next = q.peek();
//                 }
                
//                 if(node.left!=null){
//                     q.add(node.left);
//                 }
//                 if(node.right!=null){
//                     q.add(node.right);
//                 }
//             }
//         }
        
//         return root;
//     }
    
    public Node connect(Node root) {
        if(root==null){
            return root; 
        }
        
        Node curr = root;
        
        while(curr.left!=null){
            Node node = curr;
            
            while(true){
                node.left.next = node.right;
                if(node.next!=null){
                    node.right.next = node.next.left;
                    node = node.next;
                } else{
                    break;
                }
            }
            
            curr = curr.left;
        }
        
        return root;
    }
}