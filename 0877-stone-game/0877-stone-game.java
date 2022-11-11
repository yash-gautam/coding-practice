class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][][] dp = new int[n][n][2];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<2; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        
        return solve(piles, 0, piles.length-1, 1, dp)>=0;
    }
    
    public int solve(int[] piles, int start, int end, int turn, int[][][] dp){
        
        if(start>end){
            return 0;
        }
        
        if(dp[start][end][turn]!=-1){
            return dp[start][end][turn];
        }
        
        int ans = 0;
        if(turn==1){
            int alice_start = piles[start] + solve(piles, start+1, end, 0, dp);
            int alice_end = piles[end] + solve(piles, start, end-1, 0, dp);
            
            ans = Math.max(alice_start, alice_end);
        } else if(turn==0){
            int bob_start = -1*piles[start] + solve(piles, start+1, end, 1, dp);
            int bob_end = -1*piles[end] + solve(piles, start, end-1, 1, dp);

            ans = Math.min(bob_start, bob_end);
        }
        
        return dp[start][end][turn] = ans;
    }
}