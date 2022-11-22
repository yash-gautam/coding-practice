class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            dp[i] = n+100;
        }
        int back = 1;
        
        for(int i=2; i<=n; i++){            
            back = 1;
            int j = (i-back*back);
            while(j>=0){
                dp[i] = Math.min(dp[i], dp[j]);
                back++;
                j = (i-back*back);
            }
            
            dp[i]++;
        }
        
        return dp[n];
    }
}