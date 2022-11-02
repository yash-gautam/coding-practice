class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if(n<3) return false;
        
        boolean peak = false;
        
        for(int i=1; i<n-1; i++){
            int curr = arr[i];
            int prev = arr[i-1];
            int nxt = arr[i+1];
            
            if(!peak && curr>prev){
                if(curr>nxt){
                    peak = true;
                }
            } else if(peak && curr>nxt){
                
            } else {
                return false;
            }
        }
        
        return peak ? true:false;
    }
}