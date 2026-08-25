import java.util.HashMap;
import java.util.Map;

public class StringProcessor {
    public static int countWords(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }

        text = text.trim();
        String[] words = text.trim().split("\\s+");
        return words.length;
    }

    public static String reverse(String text) {
        if (text == null || text.trim().isEmpty()) {
            return "";
        }

        // REVIEW [P2 - CẦN SỬA]: Không nối String trong vòng lặp vì mỗi lần nối tạo object mới.
        // Hãy dùng StringBuilder (ví dụ new StringBuilder(text).reverse().toString()).
        String result = "";

        for(int i = text.length() - 1; i >= 0; i--) {
            result = result + text.charAt(i);
        }
        return result;
    }

    public static boolean isPalindrome(String text) {

        if (text == null || text.trim().isEmpty()) {
            return false;
        }

        text = text.replaceAll("\\s+", "").toLowerCase();

        String reversed = reverse(text);

        return text.equals(reversed);
    }

    public static Map<String, Integer> wordFrequency(String text) {
        Map<String, Integer> result = new HashMap<>();

        if (text == null || text.trim().isEmpty()) {
            return result;
        }

        text = text.trim().toLowerCase();

        String[] words = text.split("\\s+");

        for (String word : words) {
            if (result.containsKey(word)) {
                result.put(word, result.get(word) + 1);
            } else {
                result.put(word, 1);
            }
        }
        return result;
    }

}
