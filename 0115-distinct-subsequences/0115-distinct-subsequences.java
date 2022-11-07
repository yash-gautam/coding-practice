class Solution {
    public int numDistinct(String s, String t) {
        
        int n = s.length();
        int m = t.length();
        
        if(n<m){
            return 0;
        }
        
        int[][] dp = new int[n+1][m+1];
        
        for(int i=0; i<m; i++){
            dp[0][i] = 0;
        }
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
    
    public int solve(String s, int i, String t, int j, int[][] dp){
                
        if(j==0){
            return 1;
        }
        
        if(i==0){
            return 0;
        }
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        int not_take = 0;
        int take = 0;
        
        not_take = solve(s, i-1, t, j, dp);
        if(s.charAt(i-1)==t.charAt(j-1)){
            take += solve(s, i-1, t, j-1, dp);
        }
        
        return dp[i][j] = take + not_take;
    }
}