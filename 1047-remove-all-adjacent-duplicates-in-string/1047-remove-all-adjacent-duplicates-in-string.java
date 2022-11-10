class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stk = new Stack<>();
        
        for(char ch: s.toCharArray()){
            if(!stk.isEmpty() && stk.peek()==ch){
                stk.pop();
            } else{
                stk.push(ch);
            }
        }
        
        String ans = "";
        while(!stk.isEmpty()){
            ans = stk.pop() + ans;
        }
        
        return ans;
    }
}