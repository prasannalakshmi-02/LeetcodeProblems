class Solution {
    public int magicalString(int n) {
        if (n <= 0) return 0;
        if (n <= 3) return 1; 
        int[] magic = new int[n + 1];
        magic[0] = 1;
        magic[1] = 2;
        magic[2] = 2;
        int reader = 2; 
        int writer = 3;  
        int nextBlock = 1;    
        int countOfOnes = 1;  
        while (writer < n) {
            int blocksToBuild = magic[reader];
            for (int i = 0; i < blocksToBuild && writer < n; i++) {
                magic[writer] = nextBlock;
                if (nextBlock == 1) {
                    countOfOnes++;
                }
                writer++; 
            }
            nextBlock = (nextBlock == 1) ? 2 : 1;
            reader++;
        }
        return countOfOnes;
    }
}