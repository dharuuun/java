public class ReverseWords {
    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(new StringBuilder(word).reverse().toString()).append(" ");
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's code!")); // Output: "s'teL !edoc"
    }
}
