class StringIterator {
    String res;
    int ptr = 0;
    int num = 0;
    char ch = ' ';

    public StringIterator(String s) {
        res = s;
    }

    // 每次取下一个值的时候，对缓存 ch 和 num 进行计算
    public char next() {
        if (!hasNext()) {
            return ' ';
        }
        if (num == 0) {
            ch = res.charAt(ptr++);
            while (ptr < res.length() && Character.isDigit(res.charAt(ptr))) {
                num = num * 10 + res.charAt(ptr) - '0';
                ptr++;
            }
        }
        num--;
        return ch;
    }

    public boolean hasNext() {
        return ptr != res.length() || num != 0;
    }
}

public class LC_604_DesignCompressedStringIterator {
    
}