class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if(n<3) return false;
        
        boolean hitPeak = false;
        
        for(int i=1; i<n-1; i++){
            int curr = arr[i];
            int prev = arr[i-1];
            int nxt = arr[i+1];
            
            if(!hitPeak && curr>prev){
                if(curr>nxt){
                    hitPeak = true;
                }
            } else if(hitPeak && curr>nxt){
                continue;
            } else {
                return false;
            }
            
        }
        
        return hitPeak ? true:false;
    }
}