class Solution_1134 {
    public boolean isArmstrong(int n) {
        int num = n;
        String s_ori = String.valueOf(num);
        int len = s_ori.length();
        int sum = 0;
        for(int i = 0; i < len; i++){
            sum += Math.pow(num % 10,len);
            num = num / 10; 
        }

        return sum == n;
    }
}

public class LC_1134_ArmstrongNumber {
    
}