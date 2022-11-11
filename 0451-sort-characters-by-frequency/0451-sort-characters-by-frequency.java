class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        
        PriorityQueue<Character> pq = new PriorityQueue<>((b, a)->map.get(a)-map.get(b));
        for(Character key: map.keySet()){
            pq.add(key);
        }
        
        String res = "";
        while(!pq.isEmpty()){
            char ch = pq.remove();
            int freq = map.get(ch);
            while(freq-->0){
                res+=ch;
            }
        }
        
        return res;
    }
}