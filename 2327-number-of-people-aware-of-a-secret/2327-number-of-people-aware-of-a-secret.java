class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] dp = new long[n+1];
        dp[1] = 1;
        long peopleFound = 0;
        long mod = (long)(1e9+7);
        
        for(int i=2; i<=n; i++){
            long peopleSharing = dp[Math.max(i-delay, 0)];
            long peopleForgot = dp[Math.max(i-forget, 0)];
            
            peopleFound += (peopleSharing - peopleForgot + mod)%mod;
            dp[i] = peopleFound;            
        }
        
        long count = 0;
        for(int i=n-forget+1; i<=n; i++){
            count = (count+dp[i])%mod;
        }
        
        return (int)(count);
    }
}