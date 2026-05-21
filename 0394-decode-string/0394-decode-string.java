class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int cntNumber = 0;
        for(char ch : s.toCharArray()){
            if(ch >= '0' && ch<='9'){
                cntNumber = (cntNumber * 10) + (ch - '0');
            }else if(ch >='a' && ch <= 'z'){
                currentString.append(ch);
            }else if(ch == '['){
                numStack.push(cntNumber);
                strStack.push(currentString);
                cntNumber = 0;
                currentString = new StringBuilder();
            }else if(ch == ']'){
                int k = numStack.pop();
                StringBuilder previousString = strStack.pop();
                for (int i = 0; i < k; i++) {
                    previousString.append(currentString);
                }
                currentString = previousString;
            }
        }
        return currentString.toString();
    }
}