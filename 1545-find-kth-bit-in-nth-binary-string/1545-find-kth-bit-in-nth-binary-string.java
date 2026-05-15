class Solution {
    public char findKthBit(int n, int k) {
        if(n == 1)return '0';
        int length = (1<<n)-1;
        int mid = length/2+1;
        if(mid == k){
            return '1';
        }    
        else if(k < mid){
            return findKthBit(n-1, k);
        }    
        else if(k > mid){
            int mirroredK = length - k + 1;
            char leftBit = findKthBit(n - 1, mirroredK);
            return leftBit == '0' ? '1' : '0';
        }
        return '0';
    }    
}