class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        String reversedString = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + reversedString;
        int[] lps = new int[combined.length()];
        for (int i = 1; i < combined.length(); i++) {
            int j = lps[i - 1]; 
            while (j > 0 && combined.charAt(i) != combined.charAt(j)) {
                j = lps[j - 1];
            }
            if (combined.charAt(i) == combined.charAt(j)) {
                lps[i] = j + 1;
            }
        }
        int longestPalindromeLength = lps[combined.length() - 1];
        String leftovers = s.substring(longestPalindromeLength);
        return new StringBuilder(leftovers).reverse().toString() + s;
    }
}