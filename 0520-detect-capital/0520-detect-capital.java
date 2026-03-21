class Solution {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        int capitalCnt = 0;
        for(int i=0; i<n; i++){
            if(Character.isUpperCase(word.charAt(i))){
                capitalCnt++;
            }
        }
        return capitalCnt == n || capitalCnt == 0 || (capitalCnt == 1 && Character.isUpperCase(word.charAt(0)));
    }
}