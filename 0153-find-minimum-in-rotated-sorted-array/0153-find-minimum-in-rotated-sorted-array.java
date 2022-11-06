class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int h = nums.length-1;
        int ans = 0;
        
        while(l<=h){
            int mid = l+(h-l)/2;
            
            if(mid<h && nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }
            
            if(mid>l && nums[mid]<nums[mid-1]){
                return nums[mid];
            }
            
            if(nums[mid]>nums[l]){
                l = mid+1;
            } else{
                h = mid-1;
            }
        }
        
        return nums[0];
    }
}