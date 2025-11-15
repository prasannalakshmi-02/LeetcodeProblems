class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String str : tokens){
            if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")){
                int num2 = stack.pop();
                int num1 = stack.pop();
                int result = 0;
                switch(str){
                    case "+" : result = num1 + num2; break;
                    case "-" : result = num1 - num2; break;
                    case "*" : result = num1 * num2; break;
                    case "/" : result = num1 / num2; break;        
                }
                stack.push(result);
            }else{
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
}