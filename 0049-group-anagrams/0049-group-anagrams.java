class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            int[] freq = new int[26];
            for(char ch : s.toCharArray()){
               freq[ch - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int num : freq){
                sb.append(num).append('#');
            }
            String key = sb.toString();
            map.computeIfAbsent(key, k->new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}