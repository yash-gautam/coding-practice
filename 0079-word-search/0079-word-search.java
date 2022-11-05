class Solution {
    public boolean exist(char[][] board, String word) {
        return solve(board, word);
    }
    
    boolean solve(char[][] board, String word){
        int n = board.length;
        int m = board[0].length;
        
        int[][] vis = new int[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j]==word.charAt(0) && hasWord(board, i, j, word, 0, vis)){
                    return true;
                }
            }
        }
        
        return false;    
    }
    
    boolean hasWord(char[][] board, int r, int c, String word, int idx, int[][] vis){
        
        if(idx==word.length()){
            return true;
        }
        
        if(r<0 || c<0 || r>=board.length || c>=board[0].length ||
          board[r][c]!=word.charAt(idx) || vis[r][c]==1){
            return false;
        }
        
        vis[r][c]=1;
        boolean up = hasWord(board, r-1, c, word, idx+1, vis);
        boolean down = hasWord(board, r+1, c, word, idx+1, vis);
        boolean left = hasWord(board, r, c-1, word, idx+1, vis);
        boolean right = hasWord(board, r, c+1, word, idx+1, vis);
        vis[r][c]=0;
        
        return up || down || left || right;
    }
}