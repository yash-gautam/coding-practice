class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int max = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                    max = Math.max(max, solve(grid, i, j));
                }
            }
        }
        
        return max;
    }
    
    public int solve(int[][] grid, int r, int c){
        
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]==0){
            return 0;
        }
        
        grid[r][c] = 0;
        int left = solve(grid, r, c-1);
        int right = solve(grid, r, c+1);
        int up = solve(grid, r-1, c);
        int down = solve(grid, r+1, c);
        
        return 1+left+right+up+down;
    }
}