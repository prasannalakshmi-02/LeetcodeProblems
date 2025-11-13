class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] parts = path.split("/");
        for(String part : parts){
            if(part.equals("") || part.equals(".")){
                continue;
            }else if(part.equals("..")){
                if(!stack.isEmpty()) stack.pop();
            }else{
                stack.push(part);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String part : stack){
            sb.append("/").append(part);
        }
        return sb.length()==0 ? "/" : sb.toString();
    }
}