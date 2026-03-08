class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int targetIdx = 0;
        for(int i=1; i<=n; i++){
            res.add("Push");
            if(i == target[targetIdx]){
               targetIdx++;
            }else{
                res.add("Pop");
            }
            if (targetIdx == target.length) {
                break; 
            }
        }
        return res;
    }
}