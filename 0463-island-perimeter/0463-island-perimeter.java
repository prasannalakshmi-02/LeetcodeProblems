class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int perimeter = 0;
        int[][] directions = {{-1, 0},
                              {1, 0},
                              {0, -1},
                              {0, 1} };
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 1){
                    for(int[] dir : directions){
                        int newRow = i + dir[0];
                        int newCol = j + dir[1];
                        if (newRow < 0 || newRow >= rows ||
                            newCol < 0 || newCol >= cols) {
                            perimeter++;
                        }else if (grid[newRow][newCol] == 0) {
                            perimeter++;
                        }
                    }
                }
            }
        } 
        return perimeter;                     
    }
}