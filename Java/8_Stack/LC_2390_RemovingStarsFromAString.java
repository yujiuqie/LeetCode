class Solution {
    public String removeStars(String s) {
        StringBuilder rs = new StringBuilder();
        // 遍历每个字符
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                // 尾部移除一位
                rs.deleteCharAt(rs.length() - 1);
            } else {
                rs.append(c);
            }
        }

        return rs.toString();
    }
}

public class LC_2390_RemovingStarsFromAString {

}
