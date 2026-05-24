class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), 1, n, k);
        return res;
    }
    private static void backtrack( List<List<Integer>> res, List<Integer> currentPath, int start, int n, int k){
        if(currentPath.size() == k){
            res.add(new ArrayList<>(currentPath));
            return;
        }
        for(int i=start; i<=n; i++){
            currentPath.add(i);
            backtrack(res, currentPath, i+1, n, k);
            currentPath.remove(currentPath.size()-1);
        }
    }
}