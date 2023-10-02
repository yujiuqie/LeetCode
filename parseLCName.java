class parseLCName {
    public static void main(String[] args) {
        String name = "122. Best Time to Buy and Sell Stock II";
        // Boolean[] parseTag = new Boolean[]{false,true,false};    //Java
        // Boolean[] parseTag = new Boolean[]{true,false,false};     //Swift
        Boolean[] parseTag = new Boolean[]{true,true,false};     //Swift + Java
        print(name,parseTag);
    }

    private static void print(String enName, Boolean[] parse) {
        String[] res = parse(enName);
        String swift = parse[0] ? "[Swift](LC_" + res[2] + ".swift)" : "[Swift]";
        String java = parse[1] ? "[Java](LC_" + res[2] + ".java)" : "[Java]";
        String javascript = parse[2] ? "[JavaScript](LC_" + res[2] + ".js)" : "[JavaScript]";
        System.out.println("| [" + res[0] + "](" + res[1] + ")| " + swift + " | " + java + " | " + javascript + " | | ");
    }

    private static String[] parse(String enName) {
        String[] indexAndName = (enName.replace('.', ' ')).split(" ");
        int len = indexAndName.length;
        String[] res = new String[len - 2];
        for (int i = 2; i < len; i++) {
            String tmp = indexAndName[i].toLowerCase();
            tmp = tmp.replaceAll("[^0-9a-zA-Z]", "");
            res[i - 2] = tmp;
        }

        String fullUrl = "https://leetcode.cn/problems/" + String.join("-", res) + '/';

        String fullName = indexAndName[0] + "_";
        for (int i = 1; i < len; i++) {
            String str = indexAndName[i];
            str = str.replaceAll("[^0-9a-zA-Z]", "");
            if (str.length() == 0) {
                continue;
            }

            String tName = "";

            if (str.equals(str.toUpperCase())) {
                tName = str;
            } else {
                tName = Character.toUpperCase(str.charAt(0)) + str.substring(1);
            }

            fullName = fullName + tName;
        }

        return new String[] { enName, fullUrl, fullName };
    }
}