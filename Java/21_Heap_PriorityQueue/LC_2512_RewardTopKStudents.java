class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report,
            int[] student_id, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]);
        Set<String> positive = new HashSet<>();
        Set<String> negative = new HashSet<>();

        for (String s : positive_feedback) {
            positive.add(s);
        }

        for (String s : negative_feedback) {
            negative.add(s);
        }

        for (int i = 0; i < report.length; i++) {
            String s = report[i];
            String[] words = s.split(" ");
            int score = 0;
            for (String word : words) {
                if (positive.contains(word)) {
                    score += 3;
                } else if (negative.contains(word)) {
                    score--;
                }
            }

            pq.offer(new int[] { student_id[i], score });
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(pq.poll()[0]);
        }

        return list;
    }
}

public class LC_2512_RewardTopKStudents {

}
