class Solution {
    public int addDigits(int num) {

        if (num == 0) return 0;
        return 1 + (num - 1) % 9;
        /*int n = num;
        while(n > 9){
            int sum = 0;
            while(n > 0){
               sum += n%10;
               n /= 10;
            }
            n = sum;
        }
        return n;*/
    }
}