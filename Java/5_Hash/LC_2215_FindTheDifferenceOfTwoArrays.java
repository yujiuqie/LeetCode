class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int n : nums2) {
            set2.add(n);
        }
        for (int n : nums1) {
            set1.add(n);
        }
        for (int n : nums2) {
            set1.remove(n);
        }
        for (int n : nums1) {
            set2.remove(n);
        }

        return List.of(List.copyOf(set1), List.copyOf(set2));
    }
}

public class LC_2215_FindTheDifferenceOfTwoArrays {

}
