class Solution {
    public int fib(int n) {
        if(n <=1)return n;
        int f1 = 0;
        int f2 = 1;
        int f3 = 0;
        int i = 2;
        while(i<=n){
            f3 = f1+f2;
            f1 = f2;
            f2 = f3;
            i++;
        }
        return f3;
    }
}