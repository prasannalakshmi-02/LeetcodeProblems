class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] arr = new int[n*n+1];
        boolean leftToRight = true;
        int idx = 1;
        for(int r=n-1; r>=0; r--){
            if(leftToRight){
                for(int c=0; c<n; c++){
                    arr[idx++] = board[r][c];
                }
            }else{
                for(int c=n-1; c>=0; c--){
                    arr[idx++] = board[r][c];
                }
            }
            leftToRight = !leftToRight;
        }
        int target = n*n;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[target+1];
        q.add(1);
        visited[1] = true;
        int moves = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int curr = q.poll();
                if(curr == target)return moves;
                for(int dice=1; dice<=6; dice++){
                    int next = curr + dice;
                    if(next > target)continue;
                    int dest = (arr[next] == -1) ? next : arr[next];
                    if(!visited[dest]){
                        visited[dest] = true;
                        q.add(dest);
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}