class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int totalSeconds = 0;
        int targetTickets = tickets[k];
        for(int i=0; i<tickets.length; i++){
            if(i<=k){
                totalSeconds += Math.min(tickets[i], targetTickets);
            }else{
                totalSeconds += Math.min(tickets[i], targetTickets-1); 
            }
        }
        return totalSeconds;
    }
}