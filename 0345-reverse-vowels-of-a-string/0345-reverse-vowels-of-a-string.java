class Solution {
    public String reverseVowels(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        
        int start = 0;
        int end = n-1;
        
        while(start<end){
            while(start<end && isVowel(arr[start])==false){
                start++;
            }
            while(start<end && isVowel(arr[end])==false){
                end--;
            }
            
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            
            start++;
            end--;            
        }
        
        return String.valueOf(arr);
    }
    
    void print(char[] arr){
        for(char ch: arr){
            System.out.print(ch+", ");
        }
        System.out.println();
    }
    boolean isVowel(char ch){
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' 
               || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U'){
            return true;
        }
        
        return false;
    }
}