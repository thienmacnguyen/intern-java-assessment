import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // bổ sung test edge case và giao lại bài trước khi chuyển sang phần Spring nâng cao.
        int[] numbers = {5, 2, 8, 2, 10, -1, 8};

        int max = ArrayProcessor.findMax(numbers);
//        try {
//            ArrayProcessor.findMax(null);
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }
//
//        try {
//            ArrayProcessor.findMax(new int[]{});
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }

        int min = ArrayProcessor.findMin(numbers);
//        try {
//            ArrayProcessor.findMin(null);
//        } catch (IllegalArgumentException e) {
//            System.out.println("findMin null: " + e.getMessage());
//        }
//
//        try {
//            ArrayProcessor.findMin(new int[]{});
//        } catch (IllegalArgumentException e) {
//           System.out.println("findMin empty: " + e.getMessage());
//        }

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

        ProductManager manager = new ProductManager();
        manager.addProduct(new Product("P001", "Laptop Basic", "Laptop", new BigDecimal("15000000"), 5));
        manager.addProduct(new Product("P002", "Mouse Wireless", "Accessory", new BigDecimal("350000"), 20));
        manager.addProduct(new Product("P003", "Keyboard USB", "Accessory", new BigDecimal("450000"), 12));
        manager.addProduct(new Product("P004", "Monitor 24 inch", "Monitor", new BigDecimal("3200000"), 7));
        manager.addProduct(new Product("P005", "Laptop Office", "Laptop", new BigDecimal("18500000"), 3));
        System.out.println("Thêm thành công 5 sản phẩm.");

        System.out.println(manager.getAllProducts());

        Product p003 = manager.findById("P003");
        System.out.println(p003 != null ? p003 : "Không tìm thấy");
        System.out.println(manager.findByName("Laptop"));

        manager.sortByPriceAscending();
        System.out.println("Sắp xếp sản phẩm tăng dần");
        System.out.println(manager.getAllProducts());


        manager.sortByPriceDescending();
        // Method đang sort giảm dần nhưng message bên dưới ghi tăng dần.
        System.out.println("Sắp xếp sản phẩm giảm dần");
        System.out.println(manager.getAllProducts());

        System.out.println(
                "Giá trị giỏ hàng = " +
                        manager.calculateInventoryValue()
        );

        manager.updateQuantity("P002", 25);

        System.out.println("Cập nhật P002:");
        System.out.println(manager.findById("P002"));

        manager.removeProduct("P004");

        System.out.println("Đã xóa P004:");
        System.out.println(manager.getAllProducts());

        try {

            manager.addProduct(
                    new Product(
                            "P001",
                            "Laptop New",
                            "Laptop",
                            new BigDecimal("16000000"),
                            10
                    )
            );

        } catch (RuntimeException e) {

            System.out.println(
                    "Duplicate error: " + e.getMessage()
            );
        }

        try {

            manager.updateQuantity("P999", 10);

        } catch (RuntimeException e) {

            System.out.println(
                    "Not found error: " + e.getMessage()
            );
        }

    }
}
