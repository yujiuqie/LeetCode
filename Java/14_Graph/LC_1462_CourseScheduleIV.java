class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int[] indgree = new int[numCourses];
        List<List<Integer>> adjacent = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adjacent.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            indgree[prerequisite[1]]++;
            adjacent.get(prerequisite[0]).add(prerequisite[1]);
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indgree[i] == 0) {
                queue.add(i);
            }
        }

        boolean[][] isPre = new boolean[numCourses][numCourses];

        while (!queue.isEmpty()) {
            int pre = queue.poll();
            List<Integer> list = adjacent.get(pre);
            for (int cur : list) {
                isPre[pre][cur] = true;
                for (int i = 0; i < numCourses; i++) {
                    isPre[i][cur] = isPre[i][cur] || isPre[i][pre];
                }
                indgree[cur]--;
                if (indgree[cur] == 0) {
                    queue.add(cur);
                }
            }
        }

        List<Boolean> res = new ArrayList<Boolean>();
        for (int[] query : queries) {
            res.add(isPre[query[0]][query[1]]);
        }
        return res;
    }
}

public class LC_1462_CourseScheduleIV {

}
