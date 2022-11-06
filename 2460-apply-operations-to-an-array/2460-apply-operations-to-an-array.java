class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        
        int i=0;
        int j=0;
        while(i<n){
            if(i<n-1 && nums[i]==nums[i+1]){
                nums[i]=2*nums[i];
                nums[i+1]=0;
            }
            
            if(nums[i]!=0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
            
            i++;
        }
                
        return nums;
    }
}