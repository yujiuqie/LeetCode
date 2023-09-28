class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int size = rooms.size();
        boolean[] visited = new boolean[size];
        dfs(0, rooms, visited);
        for (boolean flag : visited) {
            if (!flag) {
                return false;
            }
        }

        return true;
    }

    private void dfs(int key, List<List<Integer>> rooms, boolean[] visited) {
        if (visited[key]) {
            return;
        }

        visited[key] = true;

        for (int k : rooms.get(key)) {
            dfs(k, rooms, visited);
        }
    }
}

public class LC_841_KeysAndRooms {

}
