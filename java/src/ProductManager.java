import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductManager {

    private final List<Product> products = new ArrayList<>();
    public void addProduct (Product p) {

        if (p == null) {
            throw new RuntimeException(
                    "Chưa có sản phẩm nào"
            );
        }

        if (isIdExist(p.getId())) {
            throw new RuntimeException(
                    "Sản phẩm đã tồn tại: " + p.getId()
            );
        }
        products.add(p);
    }
    public Product findById(String id) {
        // Contract hiện chưa nhất quán: id null thì ném RuntimeException, không tìm thấy lại trả null.
        // Hãy chọn một cách rõ ràng cho hàm tìm kiếm
        if (id == null || products == null) {
            return null;
        }
        for (Product p : products) {
            if (p != null && p.getId() != null) {
                if (p.getId().trim().equalsIgnoreCase(id.trim())) {
                    return p;
                }
            }
        }
        return  null;
    }

    public List<Product> findByName(String keyword) {
        List<Product> result = new ArrayList<>();
        if (keyword == null || keyword.trim().isEmpty()) {
            return result;
        }

        String searchKey = keyword.trim().toLowerCase();
        for (Product p : products) {
            if (p.getName().toLowerCase().contains(searchKey)) {
                result.add(p);
            }
        }
        return result;
    }

    public List<Product> findByCategory(String category) {

        List<Product> result = new ArrayList<>();

        if (category == null || category.trim().isEmpty()) {
            return result;
        }

        String searchCategory = category.trim();

        for (Product p : products) {

            if (p.getCategory().equalsIgnoreCase(searchCategory)) {
                result.add(p);
            }
        }

        return result;
    }

    public void sortByPriceAscending() {
        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getPrice().compareTo(p2.getPrice());
            }
        });
    }

    public void sortByPriceDescending() {
        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p2.getPrice().compareTo(p1.getPrice());
            }
        });
    }

    public BigDecimal calculateInventoryValue() {
        BigDecimal total = BigDecimal.ZERO;
        for (Product p : products) {
            BigDecimal itemTotal = p.getPrice().multiply(BigDecimal.valueOf(p.getQuantity()));
            total = total.add(itemTotal);
        }
        return total;
    }

    public void updateQuantity(String id, int newQuantity) {
        if (newQuantity < 0) {
            throw new RuntimeException(
                    "Số lượng không được âm"
            );
        }
        Product p = findById(id);
        if (p == null) {
            throw new RuntimeException(
                    "Không tìm thấy sản phẩm: " + id
            );
        }
        p.setQuantity(newQuantity);
    }

    public void removeProduct(String id) {
        Product p = findById(id);
        if (p == null) {
            throw new RuntimeException(
                    "Không tìm thấy sản phẩm: " + id
            );
        }
        products.remove(p);
    }

    public List<Product> getAllProducts() {
        // unmodifiableList chỉ chặn add/remove từ bên ngoài; Product bên trong vẫn mutable.
        // Hãy giải thích shallow copy và cách bảo vệ dữ liệu nếu cần snapshot an toàn.
        // Shallow copy là tạo list mới nhưng product vẫn là object cũ, list mới và list cũ cùng trỏ tới
        // 1 object ví dụ xóa list có thể không ảnh hưởng gì nhưng set thông tin thì vẫn thay đôi object cũ
        // cách bảo vệ đó là dùng deep copy cho từng product 1
            List<Product> snapshot = new ArrayList<>();

            for (Product p : products) {
                Product copy = new Product(
                        p.getId(),
                        p.getName(),
                        p.getCategory(),
                        p.getPrice(),
                        p.getQuantity()
                );

                snapshot.add(copy);
            }

            return Collections.unmodifiableList(snapshot);
    }

    private boolean isIdExist(String id) {
        if (id == null) return false;
        for (Product p : products) {
            if (p.getId().equalsIgnoreCase(id.trim())) {
                return true;
            }
        }
        return false;
    }
}
