class Solution {
    public int minAddToMakeValid(String s) {
        int n = s.length();
        int steps = 0;
        
        Stack<Character> stk = new Stack<>();
        for(char ch: s.toCharArray()){
            if(ch=='('){
                stk.push(ch);
            } else{
                if(!stk.isEmpty() && stk.peek()=='('){
                    stk.pop();
                } else{
                    steps++;
                }
            }
        }
        
        if(!stk.isEmpty()){
            steps+=stk.size();
        }
        
        return steps;
    }
}

// )