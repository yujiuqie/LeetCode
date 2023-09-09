class Solution {

    // 总结：有向无环图 - 拓扑排序问题
    // 根据依赖关系，构建邻接表、入度数组。
    // 选取入度为 0 的数据，根据邻接表，减小依赖它的数据的入度。
    // 找出入度变为 0 的数据，重复第 2 步。
    // 直至所有数据的入度为 0，得到排序，如果还有数据的入度不为 0，说明图中存在环。

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indgrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            indgrees[prerequisite[0]]++;
            adjacency.get(prerequisite[1]).add(prerequisite[0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indgrees[i] == 0) {
                queue.add(i);
            }
        }

        int exist = numCourses;

        while (!queue.isEmpty()) {
            numCourses--;
            int pre = queue.poll();
            List<Integer> list = adjacency.get(pre);
            for (int i : list) {
                indgrees[i]--;
                if (indgrees[i] == 0) {
                    queue.add(i);
                }
            }
        }

        return numCourses == 0;
    }
}

public class LC_207_CourseSchedule {

}
