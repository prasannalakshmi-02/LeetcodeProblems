class Solution {
    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int top = 0;
        for(String str : tokens){
            switch(str){
                case "+" : stack[top-2] = stack[top-2]+stack[top-1];
                           top--;
                           break;
                case "-":  stack[top - 2] = stack[top - 2] - stack[top - 1];
                           top--;
                           break;
                case "*":  stack[top - 2] = stack[top - 2] * stack[top - 1];
                           top--;
                           break;
                case "/":  stack[top - 2] = stack[top - 2] / stack[top - 1];
                           top--;
                           break;
                default :  stack[top++] = Integer.parseInt(str);
                           break;           
            }
        }
        return stack[0];
    }
}