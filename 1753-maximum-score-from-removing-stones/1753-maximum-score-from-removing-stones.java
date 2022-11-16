class Solution {
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y)->(y-x));
        pq.add(a);
        pq.add(b);
        pq.add(c);
        
        int score = 0;
        while(pq.size()>1){
            int highest = pq.poll() - 1; // remove one stone from pile with max stones
            int sec_highest = pq.poll() - 1; // remove stone from pile with second max stones
            
            if(highest!=0){
                pq.add(highest);
            }
            if(sec_highest!=0){
                pq.add(sec_highest);
            }
            
            score++;
        }
        
        return score;
    }
}