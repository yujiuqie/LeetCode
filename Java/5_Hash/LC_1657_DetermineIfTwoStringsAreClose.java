class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] c1 = new int[26];
        int[] c2 = new int[26];

        for (char c : word1.toCharArray()) {
            c1[c - 'a']++;
        }

        for (char c : word2.toCharArray()) {
            c2[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (c1[i] + c2[i] == 0) {
                continue;
            }

            //字符种类是否相同：若存在某个字符仅在 s1 或 s2 中出现过，两字符串必不接近，返回 False
            if (c1[i] == 0 || c2[i] == 0) {
                return false;
            }
        }

        Arrays.sort(c1);
        Arrays.sort(c2);
        for (int i = 0; i < 26; i++) {

            //字符频次是否相等：对 c1 和 c2 进行排序，并逐项检查，若存在 c1[i] != c2[i]，说明存在词频为 c1[i] 的字符种类数在 s1 和 s2 间并不相等，返回 False
            if (c1[i] != c2[i]) {
                return false;
            }
        }

        return true;
    }
}