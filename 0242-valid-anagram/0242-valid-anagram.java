class Solution {
    public boolean isAnagram(String s, String t) {
        int[] res = new int[26];
        for(char ch : s.toCharArray()){
             res[ch-'a']++;
        }
        for(char ch : t.toCharArray()){
            res[ch-'a']--;
        }
        for(int c : res){
            if(c!=0)return false;
        }
        return true;
    }
}