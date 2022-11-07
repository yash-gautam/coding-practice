class Solution {
    public int numDistinct(String s, String t) {
        
        int n = s.length();
        int m = t.length();
        
        if(n<m){
            return 0;
        }
        
        int[][] dp = new int[n][m];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        
        return solve(s, n-1, t, m-1, dp);
    }
    
    public int solve(String s, int i, String t, int j, int[][] dp){
                
        if(j<0){
            return 1;
        }
        
        if(i<0){
            return 0;
        }
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        int not_take = 0;
        int take = 0;
        
        not_take = solve(s, i-1, t, j, dp);
        if(s.charAt(i)==t.charAt(j)){
            take += solve(s, i-1, t, j-1, dp);
        }
        
        return dp[i][j] = take + not_take;
    }
}