import java.math.BigDecimal;

public class Product {

    private String id;
    private String name;
    private String category;
    private BigDecimal price;
    private int quantity;

    public Product(String id, String name, String category,
                   BigDecimal price, int quantity) {
        // Constructor đang gán trực tiếp field nên bỏ qua validation trong setPrice().
        // Vì vậy vẫn tạo được Product có id/name/category rỗng, price null/<= 0 hoặc quantity âm.
        // Hãy validate toàn bộ dữ liệu tại constructor hoặc gọi setter đã có validation.
        setId(id);
        setName(name);
        setCategory(category);
        setPrice(price);
        setQuantity(quantity);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        if (price == null) {
            throw new IllegalArgumentException("Price cannot be null");
        }

        if (price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0");
        }
            this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        // Validation không nên chỉ nằm ở ProductManager. Gọi product.setQuantity(-1)
        // vẫn làm object rơi vào trạng thái không hợp lệ. Hãy kiểm tra quantity >= 0 tại đây.
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }


}
