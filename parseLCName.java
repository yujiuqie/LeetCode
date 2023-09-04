class parseLCName {
    public static void main(String[] args) {
        String name = "1071. Greatest Common Divisor of Strings";
        printJava(name);
        // printSwift(name);
        // printJavaScript(name);
    }

    private static void printJava(String enName) {
        String[] res = parse(enName);
        System.out.println("|[" + res[0] + "](" + res[1] + ")| [Swift] | [Java](LC_" + res[2] + ".java) | [JavaScript] | ");
    }

    private static void printSwift(String enName) {
        String[] res = parse(enName);
        System.out.println("|[" + res[0] + "](" + res[1] + ")| [Swift](LC_" + res[2] + ".swift) | [Java] | [JavaScript] | ");
    }

    private static void printJavaScript(String enName) {
        String[] res = parse(enName);
        System.out.println("|[" + res[0] + "](" + res[1] + ")| [Swift] | [Java] | [JavaScript](LC_" + res[2] + ".js) | ");
    }

    private static String[] parse(String enName) {
        String[] indexAndName = (enName.replace('.', ' ')).split(" ");
        int len = indexAndName.length;
        String[] res = new String[len - 2];
        for (int i = 2; i < len; i++) {
            res[i - 2] = indexAndName[i].toLowerCase();
        }

        String fullUrl = "https://leetcode.cn/problems/" + String.join("-", res) + '/';

        String fullName = indexAndName[0] + "_";
        for (int i = 1; i < len; i++) {
            String str = indexAndName[i];
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

        return new String[] { enName, fullUrl,fullName };
    }
}