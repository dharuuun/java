import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int lineLength = words[i].length();
            int j = i + 1;

            while (j < words.length && lineLength + words[j].length() + (j - i) <= maxWidth) {
                lineLength += words[j].length();
                j++;
            }

            int gaps = j - i - 1;
            StringBuilder line = new StringBuilder();

            if (j == words.length || gaps == 0) {
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) line.append(" ");
                }
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } else {
                int spaces = (maxWidth - lineLength) / gaps;
                int extraSpaces = (maxWidth - lineLength) % gaps;

                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) {
                        for (int s = 0; s < spaces; s++) line.append(" ");
                        if (k - i < extraSpaces) line.append(" ");
                    }
                }
            }

            result.add(line.toString());
            i = j;
        }
        return result;
    }

    public static void main(String[] args) {
        TextJustification solution = new TextJustification();
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        System.out.println(solution.fullJustify(words, maxWidth));
    }
}
