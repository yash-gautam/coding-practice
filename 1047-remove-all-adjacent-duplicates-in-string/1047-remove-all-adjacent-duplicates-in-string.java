class Solution {
    public String removeDuplicates(String s) {
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        
        for(char ch: s.toCharArray()){
            if(i>0 && sb.charAt(i-1)==ch){
                sb.deleteCharAt(i-1);
                i--;
            } else{
                sb.append(ch);
                i++;
            }
        }
        
        
        
        return sb.toString();
    }
}