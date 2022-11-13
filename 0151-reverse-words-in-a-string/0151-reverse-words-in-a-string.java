class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        String ans = "";
        
        int ch = 0;
        int sp = 0;
        
        while(ch<n && sp<n){
            String temp = "";
            while(sp<n && s.charAt(sp)==' '){
                sp++;
            }
            ch = sp;
            
            while(ch<n && s.charAt(ch)!=' '){
                temp+=s.charAt(ch);
                ch++;
            }
            
            if(!temp.equals("")){
                ans = temp + " " + ans;
            }
            
            sp = ch;            
        }
        
        
        
        return ans.substring(0, ans.length()-1);
    }
}