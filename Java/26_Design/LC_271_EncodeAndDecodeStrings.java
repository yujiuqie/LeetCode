public class Codec {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs.size() == 0)
            return Character.toString((char) 258);

        String d = Character.toString((char) 257);
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
            sb.append(d);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        String d = Character.toString((char) 258);
        if (s.equals(d))
            return new ArrayList();

        d = Character.toString((char) 257);
        return Arrays.asList(s.split(d, -1));
    }
}