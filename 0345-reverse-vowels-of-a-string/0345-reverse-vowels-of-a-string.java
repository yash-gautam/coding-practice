class Solution {
    public String reverseVowels(String s) {
        Stack<Character> stk = new Stack<>();
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        
        for(char ch: s.toCharArray()){
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' 
               || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U'){
                stk.push(ch);
            }
        }
        
        for(char ch: s.toCharArray()){
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'
              || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U'){
                sb.append(stk.pop());
            } else{
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}