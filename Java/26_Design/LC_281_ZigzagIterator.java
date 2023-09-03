public class ZigzagIterator {
    List<Integer> list_all = new LinkedList<>();
    int length;
    int index = 0;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        int max_lenth = Math.max(v1.size(), v2.size());
        length = v1.size() + v2.size();
        for (int i = 0; i < max_lenth; i++) {
            if (i < v1.size()) {
                list_all.add(v1.get(i));
            }

            if (i < v2.size()) {
                list_all.add(v2.get(i));
            }
        }
    }

    public int next() {
        return list_all.get(index++);
    }

    public boolean hasNext() {
        return index < length;
    }
}

public class LC_281_ZigzagIterator {

}
