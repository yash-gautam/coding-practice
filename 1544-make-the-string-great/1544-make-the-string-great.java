class Solution {
    public String makeGood(String s) {
        int n = s.length();
        if(n==1){
            return s;
        }
        
        Stack<Character> stk = new Stack<>();
        for(int i=0; i<n; i++){
            char curr = s.charAt(i);
            // char prev = s.charAt(i-1);
            
            if(!stk.isEmpty() && Math.abs(curr-stk.peek())==32){
                stk.pop();
            } else{
                stk.push(curr);
            }
        }
        
        String ans = "";
        while(!stk.isEmpty()){
            ans = stk.pop() + ans;
        }
        
        
        return ans;
    }
}