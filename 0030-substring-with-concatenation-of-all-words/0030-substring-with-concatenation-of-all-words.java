class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s.length() == 0 || words.length == 0) return result;
        int m = words.length;
        int wordLen = words[0].length();
        int totalLen = words[0].length() * m;
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        for(int i=0; i<=s.length()-totalLen; i++){
            String sub = s.substring(i, i+totalLen);
            HashMap<String, Integer> seen = new HashMap<>();
            boolean isValid = true;
            for(int j=0; j<totalLen; j+=wordLen){
                String word = sub.substring(j, j + wordLen);
                if(!map.containsKey(word)){
                    isValid = false;
                    break;
                }
                seen.put(word, seen.getOrDefault(word, 0)+1);
                if(seen.get(word) > map.get(word)){
                    isValid = false;
                    break;
                }
            }
             if (isValid && seen.equals(map)) {
                result.add(i);
            }
        }
        return result;
    }
}