import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductManager {

    private final List<Product> products = new ArrayList<>();
    public void addProduct (Product p) {
        products.add(p);
    }
    public Product findById(String id) {
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
        return null;
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
        Product p = findById(id);
        p.setQuantity(newQuantity);
    }

    public void removeProduct(String id) {
        Product p = findById(id);
        products.remove(p);
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
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
