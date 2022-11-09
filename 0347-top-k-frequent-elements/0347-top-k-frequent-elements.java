class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((b,a)->map.get(a)-map.get(b));
        for(Map.Entry<Integer, Integer> set: map.entrySet()){
            pq.add(set.getKey());
        }
        
        int[] ans = new int[k];
        int i = 0;
        while(k-->0){
            ans[i++] = pq.poll();
        }
        
        return ans;
    }
}