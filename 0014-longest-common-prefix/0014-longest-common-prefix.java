class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = strs[0];
        for(int i=1; i<strs.length; i++){
            int idx = commonPrefixLen(res, strs[i]);
            res = res.substring(0, idx);
        }
        return res;
    }

    static int commonPrefixLen(String s1, String s2){
        int idx = 0;
        int minLen = Math.min(s1.length(), s2.length());
        while(idx < minLen && s1.charAt(idx) == s2.charAt(idx)){
            idx++;
        }
        return idx;
    }
}