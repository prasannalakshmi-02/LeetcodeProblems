class Solution {
    public int divide(int dividend, int divisor) {
        int quotient = 0;

        if (dividend == Integer.MIN_VALUE && divisor == -1)
             return Integer.MAX_VALUE;

        boolean negative = (dividend < 0) ^ (divisor < 0);

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        while(a >= b){
            int shift = 0;
            while((b<<shift) <= a){
                shift++;
            }
            shift--;
            a -= (b<<shift);
            quotient += (1<<shift);
        }
        if (negative)
             return -quotient;
        return quotient;
    }
}