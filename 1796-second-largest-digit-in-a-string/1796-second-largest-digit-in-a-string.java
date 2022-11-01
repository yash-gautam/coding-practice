class Solution {
    public int secondHighest(String s) {
        int n = s.length();
        
        int a = -1;
        int b = -1;
        
        for(char ch: s.toCharArray()){
            if(ch>='0' && ch<='9'){                
                int curr = Character.getNumericValue(ch);
                
                if(curr>=a){
                    b = (curr==a) ? b : a; // update b only if current value is greater than a
                    a = curr;
                } else if(curr>b){
                    b = curr;
                }
                
            }
        }
        
        return b;
    }
}