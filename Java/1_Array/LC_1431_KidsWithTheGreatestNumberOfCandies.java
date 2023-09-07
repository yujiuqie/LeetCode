class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int num : candies) {
            max = Math.max(max, num);
        }

        List<Boolean> res = new ArrayList<>();
        for (int num : candies) {
            res.add(num + extraCandies >= max);
        }

        return res;
    }
}

public class LC_1431_KidsWithTheGreatestNumberOfCandies {

}
