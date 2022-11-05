class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();
        List<List<Character>> list = new ArrayList<>();
        for(int i=0; i<numRows; i++){
            list.add(new ArrayList<>());
        }
        
        int j=0;
        while(j<n){            
            for(int i=0; i<numRows && j<n; i++){
                list.get(i).add(s.charAt(j++));
            }
            
            for(int i=numRows-2; i>0 && j<n; i--){
                list.get(i).add(s.charAt(j++));
            }
        }
        
        String ans = "";
        for(List<Character> temp: list){
            for(char ch: temp){
                ans+=ch;
            }
        }
        
        return ans;
    }
}