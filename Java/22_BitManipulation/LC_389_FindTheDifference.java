import java.util.HashMap;
import java.util.Map;

class Solution {
    public char findTheDifference(String s, String t) {
        int asciiValue = 0;
        for (char c : s.toCharArray()) {
            asciiValue ^= (int) c;
        }
        for (char c : t.toCharArray()) {
            asciiValue ^= (int) c;
        }
        return (char) asciiValue;
    }
}

public class LC_389_FindTheDifference {

}
