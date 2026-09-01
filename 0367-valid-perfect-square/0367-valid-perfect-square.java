class Solution {
    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        while(left <= right){
            int mid = left + (right-left)/2;
            long sqr = (long)mid*mid;
            if(sqr == num){
                return true;
            }else if(sqr < num){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return false;
    }
}