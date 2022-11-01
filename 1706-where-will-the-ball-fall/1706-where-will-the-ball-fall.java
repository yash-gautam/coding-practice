class Solution {
    public int[] findBall(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] dp = new int[n][m];
        for(int[] i: dp){
            Arrays.fill(i, -1);
        }
        
        int[] fall = new int[m];
        for(int i=0; i<m; i++){
            fall[i] = solve(grid, 0, i, dp);
        }
        
        return fall;
    }
    
    private int solve(int[][] grid, int row, int col, int[][] dp){        
        if(row==grid.length){
            return col;
        }
        
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        
        int res = -1;
        
        if(grid[row][col]==1){           
            if(col+1<grid[0].length && grid[row][col+1]!=-1){
                res = solve(grid, row+1, col+1, dp);
            }
        } else{
            if(col-1>=0 && grid[row][col-1]!=1){
                res = solve(grid, row+1, col-1, dp);
            }
        }
        
        return dp[row][col] = res;
        
    }
}