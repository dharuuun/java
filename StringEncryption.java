public class StringEncryption {
    public String encryptString(String input1, int input2) {
        StringBuilder result = new StringBuilder();
        for (char c : input1.toCharArray()) {
            if (Character.isLetter(c)) {
                int charValue = Character.toLowerCase(c) - 'a';
                int encryptedValue = (charValue + input2) % 26;
                char encryptedChar = (char) ('a' + encryptedValue);
                result.append(Character.isLowerCase(c) ? Character.toUpperCase(encryptedChar)
                        : Character.toLowerCase(encryptedChar));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        StringEncryption solution = new StringEncryption();
        System.out.println("Encrypted String: " + solution.encryptString("Wipro Tech", 20));
    }
}
