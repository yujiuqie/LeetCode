class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] prerequiste : prerequisites) {
            indegree[prerequiste[0]]++;
            list.get(prerequiste[1]).add(prerequiste[0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int[] res = new int[numCourses];

        int index = 0;
        while (!queue.isEmpty()) {
            numCourses--;
            int pre = queue.poll();
            res[index++] = pre;
            for (int cur : list.get(pre)) {
                indegree[cur]--;
                if (indegree[cur] == 0) {
                    queue.add(cur);
                }
            }
        }

        return numCourses == 0 ? res : new int[0];
    }
}

public class LC_210_CourseScheduleII {

}
