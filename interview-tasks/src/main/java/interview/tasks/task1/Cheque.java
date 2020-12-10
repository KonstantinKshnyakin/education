package interview.tasks.task1;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Cheque {

    private String organization;
    private LocalDateTime dateTime;
    private List<Product> productList;
    private BigDecimal amount;

    public Cheque(String organization) {
        this.organization = organization;
        this.dateTime = LocalDateTime.now();
        this.productList = new ArrayList<>();
        this.amount = BigDecimal.ZERO;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public boolean addProduct(Product product) {
        return productList.add(product);
    }

    public void addAllProducts(List<Product> productList) {
        this.productList.addAll(productList);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount() {
        for (Product product : this.productList) {
            this.amount = this.amount.add(product.getPrice());
        }
    }
}
