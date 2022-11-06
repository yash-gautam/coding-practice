class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        long max = 0;
        long sum = 0;
        
        int l = 0, r = 0;
        
        while(r<n){
            int curr = nums[r];
            
            if(!map.containsKey(curr) || r-map.get(curr)>=k){
                map.put(curr, r);
                sum+=curr;
            } else{
                l = r = map.get(curr)+1;   //shift l & r to +1 right of repeated element
                sum = 0;                   //reinitialize sum
                map.remove(curr);          // remove repeated element
                continue;
            }
            
            r++;
            if(r-l>k){                    // if window exceeds k, shift l and update sum
                sum-=nums[l++];
                max = Math.max(max, sum);
            } else if(r-l==k){            // if window size is k, update max
                max = Math.max(max, sum);
            }
            
            
        }     
        
        return max;
    }
}