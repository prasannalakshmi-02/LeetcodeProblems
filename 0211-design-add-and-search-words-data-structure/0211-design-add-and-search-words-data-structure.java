class WordDictionary {
    class TrieNode{
        TrieNode children[];
        boolean isEndOfWord;

        public TrieNode(){
            this.children = new TrieNode[26];
            this.isEndOfWord = false;
        }
    }
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            int idx = ch-'a';
           if(curr.children[idx] == null){
              curr.children[idx] = new TrieNode();
           }
           curr = curr.children[idx];
        }
        curr.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int index, TrieNode curr){
        if(index == word.length()){
            return curr.isEndOfWord;
        }
        char ch = word.charAt(index);
        if(ch != '.'){
            int childIdx = ch-'a';
            if(curr.children[childIdx] != null)return dfs(word, index+1, curr.children[childIdx]);
            else return false;
        }else{
            for(int i=0; i< 26; i++){
                if(curr.children[i] != null){
                    boolean found = dfs(word, index + 1, curr.children[i]);
                    if (found == true) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */