class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)return 0;
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == '1'){
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }
    private void bfs(char[][] grid, int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        grid[r][c] = '0';
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int currRow = curr[0];
            int currCol = curr[1];
            for(int[] dir : directions){
                int newRow = currRow + dir[0];
                int newCol = currCol + dir[1];
                if(newRow >= 0 && newRow < grid.length && 
                    newCol >= 0 && newCol < grid[0].length && 
                    grid[newRow][newCol] == '1'){
                       q.add(new int[]{newRow, newCol});
                       grid[newRow][newCol] = '0';
                }
            }
        }
    }
}