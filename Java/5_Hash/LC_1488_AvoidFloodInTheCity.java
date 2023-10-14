class Solution {
    public int[] avoidFlood(int[] rains) {
        TreeSet<Integer> sunny = new TreeSet<>(); // 有序集合，记录可用的晴天
        Map<Integer, Integer> lakeLastRain = new HashMap<>(); // 记录每个湖泊上一次下雨的时间
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1); // 初始化ans所有值都为1，来使得剩余可用晴天默认抽干一号湖泊
        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                sunny.add(i); // 将晴天的这一天加入有序集合
            } else {
                ans[i] = -1; // 下雨天，这一天的ans肯定为-1
                if (lakeLastRain.containsKey(rains[i])) {
                    // 如果这个湖泊之前也下过雨，我们就要两个下雨的区间内找到最早的不下雨天来抽空这个湖泊
                    Integer norain = sunny.ceiling(lakeLastRain.get(rains[i]));
                    if (norain == null)
                        return new int[0]; // 如果没有晴天，肯定发洪无法阻止
                    ans[norain] = rains[i]; // 否则，找到的晴天抽空rains[i]湖泊
                    sunny.remove(norain); // 这个晴天已经使用了，移除集合
                }
                lakeLastRain.put(rains[i], i); // 记录rains[i]号湖泊这一天下过雨
            }
        }
        return ans;
    }
}

public class LC_1488_AvoidFloodInTheCity {

}
