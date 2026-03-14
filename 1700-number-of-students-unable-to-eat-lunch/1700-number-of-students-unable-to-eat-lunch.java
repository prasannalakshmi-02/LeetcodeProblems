class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<>();
        for(int std : students){
            q.add(std);
        }
        int sandwichIdx = 0;
        int consecutiveRejections = 0;
        while(!q.isEmpty() && consecutiveRejections < q.size()){
            if(q.peek() == sandwiches[sandwichIdx]){
                q.poll();
                sandwichIdx++;
                consecutiveRejections = 0;
            }else{
                q.add(q.poll());
                consecutiveRejections++;
            }
        }
        return q.size();
    }
}