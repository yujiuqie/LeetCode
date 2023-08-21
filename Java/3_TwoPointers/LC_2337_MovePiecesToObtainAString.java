class Solution {
    public boolean canChange(String start, String target) {
        int n = start.length();
        int i = 0;
        int j = 0;

        while (i < n && j < n) {
            while (i < n && start.charAt(i) == '_') {
                i++;
            }

            while (j < n && target.charAt(j) == '_') {
                j++;
            }

            if (i < n && j < n) {
                if (start.charAt(i) != target.charAt(j)) {
                    return false;
                }

                char c = start.charAt(i);

                //情况一：如果 start 与 target 对应的 L 出现在了左边，则永远无法移动到 target 对应位置
                //情况二：如果 start 与 target 对应的 R 出现在了右边，则永远无法移动到 target 对应位置
                if ((c == 'L' && i < j) || (c == 'R' && i > j)) {
                    return false;
                }

                i++;
                j++;
            }
        }

        while (i < n) {
            if (start.charAt(i) != '_') {
                return false;
            }

            i++;
        }

        while (j < n) {
            if (target.charAt(j) != '_') {
                return false;
            }

            j++;
        }

        return true;
    }
}

public class LC_2337_MovePiecesToObtainAString {

}
