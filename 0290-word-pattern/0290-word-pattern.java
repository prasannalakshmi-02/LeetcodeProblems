class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split("\\s");
        if(pattern.length() != words.length) return false;
        HashMap<Character, String> mapPS = new HashMap<>();
        HashMap<String, Character> mapSP = new HashMap<>();
        for(int i=0; i<pattern.length(); i++){
            char c1 = pattern.charAt(i);
            String c2 = words[i];
            if(mapPS.containsKey(c1) && !mapPS.get(c1).equals(c2)) return false;
            if(mapSP.containsKey(c2) && !mapSP.get(c2).equals(c1)) return false;
            mapPS.put(c1, c2);
            mapSP.put(c2, c1);
        }
        return true;
    }
}