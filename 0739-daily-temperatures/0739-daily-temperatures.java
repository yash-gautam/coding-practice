class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> stk = new Stack<>();
        int[] res = new int[n];
        
        for(int i=n-1; i>=0; i--){
            while(!stk.isEmpty() && temperatures[stk.peek()]<=temperatures[i]){
                stk.pop();
            }
            res[i] = (stk.size()==0) ? 0 : stk.peek()-i;
            stk.push(i);
        }
        
        return res;
    }
}