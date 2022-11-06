class Solution {
    public int mySqrt(int x) {
        long l =  0;
        long h = x;
        long ans = 0;
        
        while(l <= h){
            long mid = (l+h)/2;
            if(mid*mid < x){
                l = mid + 1;
                ans = mid;
            }
            else if(mid*mid > x){
                h = mid - 1;
            }
            else{
                return (int)mid;
            }
        }
        return (int)ans;
    }
}