class Solution {
    public boolean isValidSudoku(char[][] board) {
        return solve(board);
    }
    
    public boolean solve(char[][] board){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j]!='.'){
                    if(!isValid(board, i, j)){
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
    
    public boolean isValid(char[][] board, int r, int c){
        for(int i=0; i<9; i++){
            
            //check row
            if( (i!=c) && board[r][c]==board[r][i]){
                return false;
            }
            
            //check column
            if( (i!=r) && board[r][c]==board[i][c]){
                return false;
            }
            
            //check 3x3 grid
            int row = (r/3)*3 + i/3;
            int col = (c/3)*3 + i%3;
            if( (r!=row && c!=col) && board[r][c]==board[row][col]){
                return false;
            }
        }
        
        return true;
    }
}