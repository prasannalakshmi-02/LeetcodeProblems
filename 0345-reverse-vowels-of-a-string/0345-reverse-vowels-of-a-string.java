class Solution {
    public String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        int i=0;
        int j = s.length()-1;
        while(i < j){
           while(i < j && !isVowel(ch[i]))i++;
           while(i < j && !isVowel(ch[j]))j--;
           char c = ch[i];
           ch[i] = ch[j];
           ch[j] = c;
           i++;
           j--;
        }
        return new String(ch);
    }
    public boolean isVowel(char ch){
        if(ch=='a' || ch=='e' || ch=='i'||ch=='o'||ch=='u'||ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'){
            return true;
        }
        return false;
    }
}