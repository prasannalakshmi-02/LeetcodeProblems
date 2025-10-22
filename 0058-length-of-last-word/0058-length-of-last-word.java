class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length()-1;
        while(i>=0 && s.charAt(i) == ' '){
            i--;
        }
        int end = i;
        while(i >= 0 && s.charAt(i) != ' '){
            i--;
        }
        int start = i;
        return s.substring(start+1, end+1).length();
    }
}