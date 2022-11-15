class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(a-b));
        int reach = 0;
        for(int i=0; i<n-1; i++){
            int diff = heights[i+1] - heights[i];
            if(diff>0){
                pq.add(diff);
            }
            if(pq.size()>ladders){
                bricks-=pq.poll();
            }
            if(bricks<0){
                break;
            }
            
            reach++;
        }
        
        return reach;
    }
}