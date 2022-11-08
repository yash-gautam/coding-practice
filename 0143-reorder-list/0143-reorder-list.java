/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null){
            return;
        }
        
        ListNode dummy = head;
        
        ListNode mid = findMiddle(dummy);
        ListNode right = reverseList(mid.next);
        mid.next = null;
        
        boolean ascending = true;
        ListNode ans = new ListNode(0);
        ListNode res = ans;
        while(dummy!=null || right!=null){
            if(ascending){
                ans.next = dummy;
                dummy = dummy.next;
                ans = ans.next;
                ascending = false;
            } else{
                ans.next = right;
                right = right.next;
                ans = ans.next;
                ascending = true;
            }
        }
        
        head = res.next;
        
    }
    
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        
        while(head!=null){
            ListNode nxt = head.next;
            head.next = prev;
            prev = head;
            head = nxt;
        }
        
        return prev;
    }
    public ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
}