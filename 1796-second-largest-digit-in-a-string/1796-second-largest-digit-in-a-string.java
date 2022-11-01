class Solution {
    public int secondHighest(String s) {
        int n = s.length();
        
        int a = -1;
        int b = -1;
        
        for(char ch: s.toCharArray()){
            if(ch>='0' && ch<='9'){                
                int ele = Character.getNumericValue(ch);
                
                if(ele>=a){
                    b = (ele==a) ? b : a;
                    a = ele;
                } else if(ele>b){
                    b = ele;
                }
                
            }
        }
        
        return b;
    }
}