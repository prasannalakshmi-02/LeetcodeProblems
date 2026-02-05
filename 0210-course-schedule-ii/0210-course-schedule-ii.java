class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for(int i=0; i<numCourses; i++) adj.add(new ArrayList<>());
        for(int[] pair : prerequisites){
            int course = pair[0];
            int prereq = pair[1];
            adj.get(prereq).add(course);
            indegree[course]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0) q.add(i);
        }
        int[] order = new int[numCourses];
        int index = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            order[index++] = curr;
            for (int neighbor : adj.get(curr)) {
               indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                   q.add(neighbor);
                }
            }
        }
        if(index != numCourses){
            return new int[0];
        }
        return order;
    }
}