class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int ele = matrix[i][j];
                
                if(!map.containsKey(i-j)){
                    map.put(i-j, ele);
                } else{
                    if(ele!=map.get(i-j)){
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}