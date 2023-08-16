import java.util.*;

class Solution_2682 {
    public int[] circularGameLosers(int n, int k) {
        boolean[] visited = new boolean[n];

        int jump = k;
        int index = 0;
        while (!visited[index]) {
            visited[index] = true;
            index = (index + jump) % n;
            jump += k;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                list.add(i + 1);
            }
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}

public class LC_2682_FindTheLosersOfTheCircularGame {

}
