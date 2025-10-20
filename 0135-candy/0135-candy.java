class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if(n == 0) return 0;
        int[] left = new int[n];
        Arrays.fill(left, 1);
        for(int i=1; i<n; i++){
            if(ratings[i] > ratings[i-1]){
                left[i] = left[i-1]+1;
            }
        }
        int total = 0;
        int right = 1;
        for(int i=n-1; i>=0; i--){
            if(i<n-1 && ratings[i] > ratings[i+1]){
                right = right+1;
            }else{
                right = 1;
            }
            total += Math.max(left[i], right);
        }
        return total;
    }
}