class Solution {
    public String maskPII(String s) {
       if(s.indexOf('@') >= 0){
          return maskEmail(s);
       }else{
          return maskPhone(s);
       } 
    }

    private String maskEmail(String s){
        s = s.toLowerCase();
        int indexOfAt = s.indexOf('@');
        return s.charAt(0) + "*****" +  s.charAt(indexOfAt-1) + s.substring(indexOfAt);
    }

    private String maskPhone(String s){
        String digits = s.replaceAll("[^0-9]", "");
        String local = "***-***-" + digits.substring(digits.length() - 4);
        if (digits.length() == 10) return local;
        if (digits.length() == 11) return "+*-" + local;
        if (digits.length() == 12) return "+**-" + local;
        return "+***-" + local;
    }
}