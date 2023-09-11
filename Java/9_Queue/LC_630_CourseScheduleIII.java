class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int sum = 0;
        for (int[] course : courses) {
            int d = course[0];
            int e = course[1];
            sum += d;
            queue.add(d);
            if (sum > e) {
                sum -= queue.poll();
            }
        }

        return queue.size();
    }
}

public class LC_630_CourseScheduleIII {

}
