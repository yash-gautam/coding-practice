class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        
        int ans = 0;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(elementsSmallerThan(matrix, mid)<k){
                ans = mid;
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        
        return ans;
    }
    
    public int elementsSmallerThan(int[][] matrix, int num){
        int n = matrix.length;
        int count = 0;
        
        for(int i=0; i<n; i++){
            int l = 0;
            int h = n-1;
            while(l<=h){
                int mid = l+(h-l)/2;
                if(matrix[i][mid]<num){
                    l = mid+1;
                } else{
                    h = mid-1;
                }
            }
            
            count+=l;
        }
        
        return count;
    }
}



