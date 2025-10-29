class Solution {
    public int mySqrt(int x) {
        if(x < 2)return x;
        int low = 0;
        int high = x/2;
        int ans = 1;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(mid*mid <= x){
                ans = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }
}