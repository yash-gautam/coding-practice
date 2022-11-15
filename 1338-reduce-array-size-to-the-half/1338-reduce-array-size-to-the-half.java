class Solution {
    public int minSetSize(int[] arr) {
        int n = arr.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: arr){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->(map.get(b)-map.get(a)));
        pq.addAll(map.keySet());
                
        int elementsLeft = n;
        int size = 0;
        while(!pq.isEmpty()){
            elementsLeft -= map.get(pq.poll());
            size++;
            if(elementsLeft<=n/2){
                break;
            }
        }
        
        return size;
    }
}