class Solution {
    public int numberOfSubstrings(String s) {
        int left = 0;
        int totalSubstrings = 0;
        int[] counts = new int[3];
        for(int right=0; right<s.length(); right++){
            char ch = s.charAt(right);
            counts[ch-'a']++;
            while(counts[0]>0 && counts[1]>0 && counts[2]>0){
                totalSubstrings += s.length()-right;
                char charToKickOut = s.charAt(left);
                counts[charToKickOut - 'a']--;
                left++;
            }
        }
        return totalSubstrings;
    }
}