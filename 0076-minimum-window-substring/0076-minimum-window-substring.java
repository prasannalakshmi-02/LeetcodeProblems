class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        String str = "";
        if(m > n) return str;
        int[] freq = new int[128];
        for(char ch : t.toCharArray()){
            freq[ch]++;
        }
        int left = 0;
        int right = 0;
        int required = m;
        int startIdx = 0;
        int minLen = Integer.MAX_VALUE;
        while(right < n){
            char ch = s.charAt(right);
            if(freq[ch] > 0){
                required--;
            }
            freq[ch]--;
            right++;
            while(required == 0){
                if(right-left < minLen){
                    minLen = right-left;
                    startIdx = left;
                }
            
            char leftChar = s.charAt(left);
            freq[leftChar]++;
            if(freq[leftChar] > 0)required++;
            left++;
            
        }
    }   
        return minLen == Integer.MAX_VALUE ? ""  : s.substring(startIdx, startIdx+minLen);
    }
}