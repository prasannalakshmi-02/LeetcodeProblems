class Solution {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> result = new ArrayList<>();
    int left = 0, right = intervals.length - 1;
    int pos = intervals.length;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (intervals[mid][1] >= newInterval[0]) {
            pos = mid;
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    for (int i = 0; i < pos; i++) {
        result.add(intervals[i]);
    }
    while (pos < intervals.length && intervals[pos][0] <= newInterval[1]) {
        newInterval[0] = Math.min(newInterval[0], intervals[pos][0]);
        newInterval[1] = Math.max(newInterval[1], intervals[pos][1]);
        pos++;
    }
    result.add(newInterval);
    while (pos < intervals.length) {
        result.add(intervals[pos++]);
    }
    return result.toArray(new int[result.size()][]);
  }
}