import java.util.ArrayList;
import java.util.List;

public class ArrayProcessor {
    public static int findMax(int[] numbers) {
        // Chưa xử lý numbers == null hoặc numbers.length == 0.
        // Hiện tại truy cập numbers[0] sẽ gây NullPointerException/ArrayIndexOutOfBoundsException.
        // Hãy thống nhất cách xử lý cho toàn bộ ArrayProcessor (ví dụ: IllegalArgumentException hoặc OptionalInt).
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    public static int findMin(int[] numbers) {
        int min = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }

    public static int findSum(int[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum = sum + numbers[i];
        }
        return sum;
    }

    public static double findAvarage(int[] numbers) {
        double sum = ArrayProcessor.findSum(numbers);
        return sum/numbers.length;
    }

    public static int countEvenNumbers(int[] numbers) {
        int evenNumbers = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                evenNumbers = evenNumbers + 1;
            }
        }
        return evenNumbers;
    }

    public static int countOddNumbers(int[] numbers) {
        int oddNumbers = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                oddNumbers = oddNumbers + 1;
            }
        }
        return oddNumbers;
    }

    public static int findSecondMax(int[] numbers) {
        // Logic này vẫn sai với dữ liệu trùng max. Ví dụ {5, 5} trả về 5,
        // trong khi không có số lớn thứ hai PHÂN BIỆT.
        // Cần chỉ cập nhật secondMax khi number < max và xử lý trường hợp không tồn tại kết quả.
        // Cần test thêm: null, {}, {5}, {5, 5}, {5, 5, 4}, Integer.MIN_VALUE.
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int number : numbers) {
            if (number > max) {
                secondMax = max;
                max = number;
            }

             else if (number > secondMax) {
                secondMax = number;
            }
        }
        return secondMax;
    }

    public static List<Integer> createNewArray(int[] numbers) {
        List<Integer> newArray = new ArrayList<>();
        for (int number : numbers) {
            if (!newArray.contains(number)) {
                newArray.add(number);
            }
        }

        return newArray;
    }
}
