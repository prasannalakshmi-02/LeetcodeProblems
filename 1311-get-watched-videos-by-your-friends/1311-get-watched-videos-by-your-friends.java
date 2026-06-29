class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n = friends.length;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        queue.offer(id);
        visited[id] = true;
        int currentLevel = 0;
        List<Integer> targetPeople = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (currentLevel == level) {
                while (!queue.isEmpty()) {
                    targetPeople.add(queue.poll());
                }
                break;
            }
            for (int i = 0; i < size; i++) {
                int person = queue.poll();
                for (int friend : friends[person]) {
                    if (!visited[friend]) {
                        visited[friend] = true;
                        queue.offer(friend);
                    }
                }
            }
            currentLevel++;
        }
        Map<String, Integer> frequency = new HashMap<>();
        for (int person : targetPeople) {
            for (String video : watchedVideos.get(person)) {
                frequency.put(
                    video,
                    frequency.getOrDefault(video, 0) + 1
                );
            }
        }
        List<String> answer = new ArrayList<>(frequency.keySet());
        Collections.sort(answer, new Comparator<String>() {
            public int compare(String a, String b) {
                int freqCompare = frequency.get(a) - frequency.get(b);
                if (freqCompare != 0) {
                    return freqCompare;
                }
                return a.compareTo(b);
            }
        });
        return answer;
    }
}