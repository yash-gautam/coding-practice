class Solution {
    public boolean canArrange(int[] arr, int k) {
        int n = arr.length;
        int pairs = n/2;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            int ele = arr[i]%k;
            if(ele<0){
                ele+=k;
            }
            int target = (k-ele)%k;
            
            if(map.containsKey(target) && map.get(target)>0){
                map.put(target, map.get(target)-1);
                pairs--;
            } else{
                map.put(ele, map.getOrDefault(ele, 0)+1);
            }
            
        }
                
        return pairs==0;
    }
}