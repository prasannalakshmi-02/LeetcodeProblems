class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int totalSeconds = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<tickets.length; i++){
            q.add(i);
        }
        while(!q.isEmpty()){
            int idx = q.poll();
            tickets[idx] = tickets[idx]-1;
            totalSeconds++;
            if(tickets[idx] > 0)q.add(idx);
            if(idx == k && tickets[idx] == 0)return totalSeconds;
        }
        return totalSeconds;
    }
}