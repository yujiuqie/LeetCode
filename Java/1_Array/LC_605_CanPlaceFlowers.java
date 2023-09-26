class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int[] flow = new int[len + 2];
        for (int i = 0; i < len + 1; i++) {
            if (i == 0 || i == len + 1) {
                flow[i] = 0;
            } else {
                flow[i] = flowerbed[i - 1];
            }
        }

        for (int i = 1; i < len + 1; i++) {
            if (flow[i - 1] == 0 && flow[i] == 0 && flow[i + 1] == 0) {
                flow[i] = 1;
                n--;
            }
        }

        return n <= 0;
    }
}

public class LC_605_CanPlaceFlowers {

}
