class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }

        int m = num1.length();
        int n = num2.length();

        //逆序末位填充
        int[] tmp = new int[m + n];
        for(int i = m - 1; i >= 0; i--){
            int v_1 = num1.charAt(i) - '0';
            for(int j = n - 1; j >= 0; j--){
                int v_2 = num2.charAt(j) - '0';
                int sum = tmp[i + j + 1] + v_1 * v_2;
                tmp[i + j + 1] = sum % 10; //填充 i + j + 1 位
                tmp[i + j] += sum / 10;//填充 i + j 位
            }
        }

        StringBuilder res = new StringBuilder();

        //移除前置 0
        int index = 0;
        while(tmp[index] == 0){
            index++;
        }

        for(int i = index; i < tmp.length; i++){
            res.append(tmp[i]);
        }

        return res.toString();
    }
}