class Solution {
    public int[] beautifulArray(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        while(res.size()<n){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int nums : res){
                if(2*nums-1 <= n){
                     temp.add(2*nums-1);
                }
            }
            for(int nums : res){
                if(2*nums <= n){
                     temp.add(2*nums);
                }
            }
            res = temp;
        }
        int[] finalArray = new int[n];
        for (int i = 0; i < n; i++) {
            finalArray[i] = res.get(i);
        }
        
        return finalArray;
    }
}