class Solution {
    String[] mapping = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backtrack(result, digits, new StringBuilder(), 0);
        return result;
    }
    private void backtrack(List<String> result, String digits, StringBuilder path, int index){
        if (path.length() == digits.length()) {
            result.add(path.toString());
            return;
        }
        char digitChar = digits.charAt(index);
        int digit = digitChar-'0';
        String letters = mapping[digit];
        for(int i=0; i<letters.length(); i++){
            char letter = letters.charAt(i);
            path.append(letter);
            backtrack(result, digits, path, index+1);
            path.deleteCharAt(path.length() - 1);
        }
    }

}