class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int res = 0;
        int left = -1;
        int right = -1;
        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                right = i;
                if (left != -1) {
                    res = Math.max(res, (right - left) / 2);
                } else {
                    res = right;
                }
                left = right;
            }
        }

        res = Math.max(res, n - right - 1);
        return res;
    }
}