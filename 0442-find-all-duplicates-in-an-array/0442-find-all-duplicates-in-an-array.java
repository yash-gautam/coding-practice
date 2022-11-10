class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++){
            int curr = Math.abs(nums[i]);
                        
            if(nums[curr-1]<0){
                list.add(curr);
            } else{
                nums[curr-1] = -1*nums[curr-1];
            }
        }
        
        return list;
    }
}