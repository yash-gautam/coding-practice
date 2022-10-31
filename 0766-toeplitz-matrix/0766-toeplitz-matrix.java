class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        int r = n-1, c = 0;
        boolean crossedTop = false;
        
        while(c<m){
            int row = r, col = c;
            int curr = -1;
            int prev = -1;
            
            if(r==0){
                crossedTop = true;
            }
            
            while(row<n && col<m){
                curr = matrix[row][col];
                if(prev!=-1 && prev!=curr){
                    // System.out.println("curr: "+curr+"prev: "+prev);
                    return false;
                }
                
                prev = curr;
                row++;
                col++;
            }
            
            if(crossedTop){
                c++;
            } else{
                r--;
            }
            
        }
        
        return true;
    }
}