class Solution {
    public boolean isValidSerialization(String preorder) {
        Stack<String> stk = new Stack<>();
        
        String[] str = preorder.split(",");
        
        for(int i=0; i<str.length; i++){
            String s = str[i];
            
            while(s.equals("#") && !stk.isEmpty() && stk.peek().equals("#")){
                stk.pop();
                if(stk.isEmpty()){
                    return false;
                }
                stk.pop();
            }
            stk.push(s);
        }
                
        return (stk.size()==1 && stk.peek().equals("#"));
    }
}