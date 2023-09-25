class SmallestInfiniteSet {

    PriorityQueue<Integer> queue;

    public SmallestInfiniteSet() {
        queue = new PriorityQueue<Integer>();
        for (int i = 1; i <= 1000; i++) {
            queue.offer(i);
        }
    }
    
    public int popSmallest() {
        return queue.poll();
    }
    
    public void addBack(int num) {
        if (!queue.contains(num)) {
            queue.offer(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */

public class LC_2336_SmallestNumberInInfiniteSet {
    
}
