class Solution {
    public double myPow(double x, int n) {        
        if(n<0){
            return rec(1/x, (n));
        } else{
            return rec(x, n);
        }
    }
    
    public double rec(double x, int n){
        if(x==0){
            return 0;
        }
        
        if(x==1 || n==0){
            return 1;
        }
        
        double val = rec(x, n/2);
        if(n%2==0){
            return val*val;
        } else{
            return val*val*x;
        }
    }
}