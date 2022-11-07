class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        
        solve(s, 0, list, new ArrayList<>());
        
        return list;
    }
    
    public void solve(String s, int idx, List<List<String>> list, List<String> temp){
        
        if(idx==s.length()){
            list.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i=idx; i<s.length(); i++){
            String sub = s.substring(idx, i+1);
            if(isPalindrome(sub)){
                temp.add(sub);
                solve(s, i+1, list, temp);
                temp.remove(temp.size()-1);
            }
        }
        
    }
    
    boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        
        return true;
    }
}