class Solution {
    public int longestPalindrome(String[] words) {
        int max = 0;

        HashMap<String, Integer> map = new HashMap<>();
        for(String s: words){
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        
        // System.out.println("map: "+map);
        
        boolean bool = false;
        
        for(String s: words){
            if(s.charAt(0)==s.charAt(1)){
                if(map.containsKey(s)){
                    max += 4*(map.get(s)/2);
                    if(map.get(s)%2!=0){
                        bool = true;
                    }
                }
            } else{
                String target = reverse(s);
                
                if(map.containsKey(target)){
                    int org = map.get(s);
                    int tar = map.get(target);
                    
                    max += 4*(Math.min(org, tar));
                    map.remove(target);
                }
            }
            
            map.remove(s);
        }
        
        if(bool){
            max+=2;
        }
        
        return max;
    }
    
    String reverse(String s){
        return s.substring(s.length()-1) + s.substring(0, s.length()-1);
    }
}