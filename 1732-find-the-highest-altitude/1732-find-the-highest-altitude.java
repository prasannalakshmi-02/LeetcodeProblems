class Solution {
    public int largestAltitude(int[] gain) {
        int currAlt = 0;
        int maxAlt = 0;
        for(int num : gain){
            currAlt += num;
            if(currAlt > maxAlt)maxAlt = currAlt;
        }
        return maxAlt;
    }
}