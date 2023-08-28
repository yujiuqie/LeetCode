class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
            }
        });

        pq.add(newInterval);

        for (int[] interval : intervals) {
            pq.add(interval);
        }

        List<int[]> list = new ArrayList<>();

        list.add(pq.poll());
        while (pq.size() > 0) {
            int[] pre = list.get(list.size() - 1);
            int[] cur = pq.poll();
            if (cur[0] <= pre[1]) {
                pre[1] = Math.max(pre[1], cur[1]);
            } else {
                list.add(cur);
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}

public class LC_57_InsertInterval {

}
