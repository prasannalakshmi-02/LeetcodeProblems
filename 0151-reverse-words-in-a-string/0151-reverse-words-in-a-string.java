class Solution {
    public String reverseWords(String s) {
       int i = s.length()-1;
       int end = s.length()-1;
       StringBuilder sb = new StringBuilder();
        while(i>=0){
           while(i >= 0 && s.charAt(i) != ' ')i--;
           sb.append(s.substring(i+1, end+1)).append(" ");
           while(i >= 0 && s.charAt(i) == ' ')i--;
           end = i;
        }  
        return sb.toString().trim();
    }
}