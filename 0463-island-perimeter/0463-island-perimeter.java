class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int per = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                    int[][] vis = new int[n][m];
                    per = solve(grid, i, j, vis);
                    break;
                }
            }
        }
        
        return per;
    }
    
    int solve(int[][] grid, int r, int c, int[][] vis){        
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]==0){
            return 1;
        }
        
        if(vis[r][c]==1){
            return 0;
        }
        
        vis[r][c] = 1;
        int left = solve(grid, r, c-1, vis);
        int right = solve(grid, r, c+1, vis);
        int up = solve(grid, r-1, c, vis);
        int down = solve(grid, r+1, c, vis);
        
        return left+right+up+down;
    }
}