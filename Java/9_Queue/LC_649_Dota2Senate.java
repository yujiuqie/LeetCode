class Solution {
    public String predictPartyVictory(String senate) {
        Deque<Integer> rd = new ArrayDeque<>();
        Deque<Integer> dd = new ArrayDeque<>();
        int n = senate.length();
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                rd.addLast(i);
            } else {
                dd.addLast(i);
            }
        }

        while (rd.size() != 0 && dd.size() != 0) {
            int a = rd.pollFirst();
            int b = dd.pollFirst();
            if (a < b) {
                rd.addLast(a + n);
            } else {
                dd.addLast(b + n);
            }
        }

        return rd.size() != 0 ? "Radiant" : "Dire";
    }
}

public class LC_649_Dota2Senate {

}
