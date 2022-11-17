class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int l1 = ax2-ax1;
        int b1 = ay2-ay1;
        
        int l2 = bx2-bx1;
        int b2 = by2-by1;
        
        int area1 = l1*b1;
        int area2 = l2*b2;
        int total = area1 + area2;
        
        int x1 = Math.max(ax1, bx1);
        int y1 = Math.max(ay1, by1);
        int x2 = Math.min(ax2, bx2);
        int y2 = Math.min(ay2, by2);
        
        if(x1<x2 && y1<y2){
            total -= (x2-x1)*(y2-y1);
        }
        
        return total;
    }
}