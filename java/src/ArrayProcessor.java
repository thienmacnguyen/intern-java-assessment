import java.util.ArrayList;
import java.util.List;

public class ArrayProcessor {
    public static int findMax(int[] numbers) {
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

    public static int findAvarage(int[] numbers) {
        int sum = ArrayProcessor.findSum(numbers);
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
            if (numbers[i] % 2 == 0) {
                oddNumbers = oddNumbers + 1;
            }
        }
        return oddNumbers;
    }

    public static int findSecondMax(int[] numbers) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int number : numbers) {
            if (number > max) {
                secondMax = max;
                max = number;
            }

            if (number > secondMax) {
                secondMax = number;
            }

            else return secondMax;
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
