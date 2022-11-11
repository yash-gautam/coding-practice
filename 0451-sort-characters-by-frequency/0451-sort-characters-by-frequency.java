class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        
        PriorityQueue<Character> pq = new PriorityQueue<>((b, a)->map.get(a)-map.get(b));
        pq.addAll(map.keySet());
        
        // char[] ans = new char[s.length()];
        // int i = 0;
        
        String res = "";
        while(!pq.isEmpty()){
            char ch = pq.remove();
            int freq = map.get(ch);
            while(freq-->0){
                res+=ch;
            }
        }
        
        // return new String(ans);
        return res;
    }
}