class Solution {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        String word;
    }
    public TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String s : words){
            TrieNode curr = root;
            for(char ch : s.toCharArray()){
                int idx = ch-'a';
                if(curr.children[idx] == null){
                    curr.children[idx] = new TrieNode();
                }
                curr = curr.children[idx];
            }
            curr.word = s;
        }
        return root;
    }
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> result = new ArrayList<>();
        for(int r=0; r<board.length; r++){
            for(int c=0; c<board[0].length; c++){
                dfs(board, r, c, root, result);
            }
        }
        return result;
    }
    public void dfs(char[][] board, int r, int c, TrieNode curr, List<String> result){
        if(r<0 || r>=board.length || c<0 || c>=board[0].length || board[r][c]  == '#')return;
        char ch = board[r][c];
        int idx = ch-'a';
        if(curr.children[idx] == null){
            return;
        }
        curr = curr.children[idx];
        if(curr.word != null){
            result.add(curr.word);
            curr.word = null;
        }
        board[r][c] = '#';
        dfs(board, r - 1, c, curr, result);
        dfs(board, r + 1, c, curr, result); 
        dfs(board, r, c - 1, curr, result); 
        dfs(board, r, c + 1, curr, result); 
        board[r][c] = ch;
    }
}