class Solution {
    public int numDistinct(String s, String t) {
        
        int n = s.length();
        int m = t.length();
        
        if(n<m){
            return 0;
        }
        
        int[][] dp = new int[n+1][m+1];
        for(int i=0; i<n; i++){
            dp[i][0] = 1;
        }
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                int not_take = 0;
                int take = 0;

                not_take = dp[i-1][j];
                if(s.charAt(i-1)==t.charAt(j-1)){
                    take += dp[i-1][j-1];
                }

                dp[i][j] = take + not_take;
            }
        }
        
        return dp[n][m];
    }
}