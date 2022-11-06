class Solution {
    public int missingNumber(int[] nums) {
        int total = 0;
        for(int i=0; i<=nums.length; i++){
            total+=i;
        }
        
        int sum = 0;
        for(int i: nums){
            sum+=i;
        }
        
        return total-sum;
    }
}