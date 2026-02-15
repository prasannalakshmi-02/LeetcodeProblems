class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>();
        for(String s : bank){
            bankSet.add(s);
        }
        if (!bankSet.contains(endGene)) return -1;
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.add(startGene);
        visited.add(startGene);
        int mutations = 0;
        char[] options = {'A', 'C', 'G', 'T'};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                String str = q.poll();
                if(str.equals(endGene))return mutations;
                for(int j=0; j<str.length(); j++){
                    char originalChar = str.charAt(j);
                    for(char opt : options){
                        if(opt == originalChar)continue;
                        char[] charArray = str.toCharArray();
                        charArray[j] = opt;
                        String newGene = new String(charArray);
                        if (newGene.equals(endGene)) return mutations + 1;
                        if (bankSet.contains(newGene) && !visited.contains(newGene)) {
                             visited.add(newGene);
                             q.add(newGene);
                        }     
                    }
                }
            }
            mutations++;
        }
        return -1;
    }
}