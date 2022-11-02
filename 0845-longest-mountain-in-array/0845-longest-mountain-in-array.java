class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        if(n<3) return 0;
        
        int max = 0;
        
        for(int i=1; i<n-1; i++){
            int prev = arr[i-1];
            int curr = arr[i];
            int nxt = arr[i+1];
            
            if(curr>prev && curr>nxt){
                int left = i-1, right=i+1;
                while(left>0 && arr[left]>arr[left-1]){
                    left--;
                }
                while(right<n-1 && arr[right]>arr[right+1]){
                    right++;
                }
                
                max = Math.max(max, right-left+1);
            }
        }
        
        return max;
    }
}