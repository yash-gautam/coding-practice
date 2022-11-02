class Solution {
    public int minMutation(String start, String end, String[] bank) {
        
        char[] choices = {'A', 'C', 'G', 'T'};
        HashSet<String> set = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        
        for(String s: bank){
            set.add(s);
        }
        
        visited.add(start);
        q.add(start);
        
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                String temp = q.poll();
                if(temp.equals(end)){
                    return steps;
                }
                
                for(int j=0; j<8; j++){
                    for(char ch: choices){
                        String node = temp.substring(0, j) + ch + temp.substring(j+1);
                        if(!visited.contains(node) && set.contains(node)){
                            q.add(node);
                            visited.add(node);
                        }
                    }
                }
                
            }
            
            steps++;
        }
        
        
        return -1;
    }
}