import java.util.*;

class parseLCName{
    public static void main(String[] args) {
        String name = "1004. Max Consecutive Ones III";
        print(name);
    }
    
    private static void print(String enName){
        System.out.println(enName);
        String[] indexAndName = (enName.replace('.', ' ')).split(" ");
        int len = indexAndName.length;
        String[] res = new String[len - 2];
        for(int i = 2; i < len;i++){
            res[i - 2] = indexAndName[i].toLowerCase();
        }
        String fullUrl = "https://leetcode.cn/problems/" + String.join("-", res) + '/';
        System.out.println("[" + enName + "](" + fullUrl + ")");

        String fullName = indexAndName[0] + "_";
        for(int i = 1; i < len; i++){
            String str = indexAndName[i];
            if(str.length() == 0){
                continue;
            }

            String tName = "";

            if(i == len - 1){
                if(str.length() < 5){
                    Set<Character> set = new HashSet<>();
                    for(char c : str.toCharArray()){
                        set.add(c);
                    }
                    if(set.size() <= 2 && (set.contains('I') || set.contains('V') )){
                        tName = str;
                    }
                }
            }

            tName = Character.toUpperCase(str.charAt(0)) + str.substring(1);
            fullName = fullName + tName;
        }

        System.out.println("LC_"+fullName+".java");
        System.out.println("LC_"+fullName+".swift");
        System.out.println("LC_"+fullName+".js");
    }
}