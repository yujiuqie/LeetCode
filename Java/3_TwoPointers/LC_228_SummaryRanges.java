import java.util.*;

class Solution {
    public List<String> summaryRanges(int[] nums) {

        List<String> res = new ArrayList<>();
        int len = nums.length;
        int left = 0;
        int right = 1;
        while(left < len){
            while(right < len && nums[right - 1] + 1 == nums[right]){
                right++;
            }
        
            if(left == right - 1){ //left 为独立元素
                res.add(String.valueOf(nums[left]));
            }
            else{   //保存 [left,right - 1] 元素
                StringBuilder str = new StringBuilder();
                str.append(nums[left]);
                str.append("->");
                str.append(nums[right - 1]);
                res.add(str.toString());
            }

            left = right;
            right = right + 1;
        }

        return res;
    }
}

public class LC_228_SummaryRanges {
    
}
