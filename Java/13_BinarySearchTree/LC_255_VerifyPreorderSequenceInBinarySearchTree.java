import java.util.*;

class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0){
            return true;
        }

        int len = preorder.length;

        int index = 0;
        while(index < len){
            if(preorder[index] > preorder[0]){
                break;
            }
            index++;
        }

        for(int j = index; j < len; j ++){
            if(preorder[j] < preorder[0]){
                return false;
            }
        }

        int[] left = Arrays.copyOfRange(preorder,1,index);
        int[] right = Arrays.copyOfRange(preorder,index,len);
        return verifyPreorder(left) && verifyPreorder(right);
    }
}