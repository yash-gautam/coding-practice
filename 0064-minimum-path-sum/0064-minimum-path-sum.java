class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] dp = new int[n][m];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        
        return rec(grid, 0, 0, dp);
    }
    
    public int rec(int[][] grid, int r, int c, int[][] dp){
        
        if(r==grid.length-1 && c==grid[0].length-1){
            return grid[r][c];
        }
        
        if(r>=grid.length || c>=grid[0].length){
            //return large value so that it gets discarded
            return Integer.MAX_VALUE;
        }
        
        if(dp[r][c]!=-1){
            return dp[r][c];
        }
        
        int right = rec(grid, r, c+1, dp);
        int down = rec(grid, r+1, c, dp);
            
        return dp[r][c] = grid[r][c] + Math.min(right, down);
    }
}