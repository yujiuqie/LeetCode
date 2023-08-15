import java.util.*;

class Solution_833 {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = s.length(), m = indices.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; ++i) {
            map.put(indices[i], i);
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n;) {
            boolean succeed = false;
            if (map.containsKey(i)) {
                int pt = map.get(i);
                if (s.startsWith(sources[pt], i)) {
                    succeed = true;
                    ans.append(targets[pt]);
                    i += sources[pt].length();
                }
            }
            if (!succeed) {
                ans.append(s.charAt(i));
                ++i;
            }
        }
        return ans.toString();
    }
}

public class LC_833_FindAndReplaceInString {

}