class Solution {
    public int removeDuplicates(int[] nums) {
        
        int k = 0;
        int idx = 0;
        
        for(int i: nums){
            if(k==0 || i>nums[k-1]){
                nums[k++] = i;
            }
        }
        
        return k;
    }        
}