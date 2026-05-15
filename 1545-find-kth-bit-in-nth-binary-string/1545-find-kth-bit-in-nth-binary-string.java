class Solution {
    public char findKthBit(int n, int k) {
        String s = "0";
        int n1 = 1;
        return findKthBitRec(s, n1, n, k);
    }
    private static char findKthBitRec(String s, int n1, int n, int k){
        if(n1 == n)return s.charAt(k-1);
        s = s+"1"+reverseAndInvert(s);
        return findKthBitRec(s, n1+1, n, k);
    }
    private static String reverseAndInvert(String s) {
    StringBuilder sb = new StringBuilder();
    // Read backwards (reverse) and flip the bits (invert) simultaneously
    for (int i = s.length() - 1; i >= 0; i--) {
        sb.append(s.charAt(i) == '0' ? '1' : '0');
    }
    return sb.toString();
}
}