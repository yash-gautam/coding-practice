class SmallestInfiniteSet {
    HashSet<Integer> set;
    PriorityQueue<Integer> pq;

    public SmallestInfiniteSet() {
        set = new HashSet<>();
        pq = new PriorityQueue<>();
        for(int i=1; i<=1000; i++){
            set.add(i);
            pq.add(i);
        }
    }
    
    public int popSmallest() {
        int smallest = pq.poll();
        set.remove(smallest);
        return smallest;
    }
    
    public void addBack(int num) {
        if(!set.contains(num)){
            pq.add(num);
            set.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */