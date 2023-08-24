import java.util.*;

class Solution_1167 {
    public int connectSticks(int[] sticks) {

        //默认小顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int stick : sticks){
            queue.add(stick);
        }

        int res = 0;
        while(queue.size() >= 2){
            int stick1 = queue.poll();
            int stick2 = queue.poll();

            int sum = stick1 + stick2;
            res += sum;
            queue.add(sum);
        }

        return res;
    }
}