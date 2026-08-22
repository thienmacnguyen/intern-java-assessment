import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 8, 2, 10, -1, 8};

        int max = ArrayProcessor.findMax(numbers);
        int min = ArrayProcessor.findMin(numbers);
        int sum = ArrayProcessor.findSum(numbers);
        double average = ArrayProcessor.findAvarage(numbers);
        int evenNumbers = ArrayProcessor.countEvenNumbers(numbers);
        int oddNumbers = ArrayProcessor.countOddNumbers(numbers);
        int secondMax = ArrayProcessor.findSecondMax(numbers);
        List<Integer> newArray = ArrayProcessor.createNewArray(numbers);

        System.out.println("Max = " + max);
        System.out.println("Min = " + min);
        System.out.println("Sum = " + sum);
        System.out.println("Average = " + average);
        System.out.println("Even numbers = " + evenNumbers);
        System.out.println("Odd numbers = " + oddNumbers);
        System.out.println("Second max = " + secondMax);
        System.out.println("New array" + newArray);

        System.out.println(StringProcessor.countWords(" Java is fun "));

        System.out.println(StringProcessor.reverse(" Java "));

        System.out.println(StringProcessor.isPalindrome("Never odd or even"));

        System.out.println(StringProcessor.wordFrequency("Java java SQL"));
    }
}
