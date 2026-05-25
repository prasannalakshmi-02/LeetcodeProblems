class Solution {
    String res = "";
    int count = 0;
    public String getHappyString(int n, int k) {
        backTrack(n, k, new StringBuilder());
        return res;
    }
    private boolean backTrack(int n, int k, StringBuilder path){
        if(path.length() == n){
            count++;
            if(count == k){
                res = path.toString();
                return true;
            }
            return false;
        }
        for(char ch='a'; ch<='c'; ch++){
            if (path.length() > 0 && path.charAt(path.length() - 1) == ch) {
                continue;
            }
            path.append(ch);
            if (backTrack(n, k, path)) {
                return true; 
            }
            path.deleteCharAt(path.length() - 1);
        }
        return false;
    }
}