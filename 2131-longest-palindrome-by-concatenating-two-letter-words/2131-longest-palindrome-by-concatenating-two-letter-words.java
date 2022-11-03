class Solution {
    public int longestPalindrome(String[] words) {
        int max = 0;
        
        int[][] dp = new int[26][26];
        
        for(String s: words){
            int a = s.charAt(0)-'a';
            int b = s.charAt(1)-'a';
            
            if(dp[b][a]!=0){
                max+=4;
                dp[b][a]--;
            } else{
                dp[a][b]++;
            }
        }
        
        for(int i=0; i<26; i++){
            if(dp[i][i]!=0){
                max+=2;
                break;
            }
        }
        
        return max;
    }
    
    String reverse(String s){
        return ""+s.charAt(1)+s.charAt(0);
    }
}