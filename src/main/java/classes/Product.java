package classes;

import java.util.Objects;

public class Product {
    private Integer id;
    private String name, description;
    private Double price;
    private Integer quantity, category_id, supplier_id;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getCategory_id() {
        return category_id;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public void setSupplier_id(Integer supplier_id) {
        this.supplier_id = supplier_id;
    }

    public Product() {
    }

    public Product(String name, String description, Double price, Integer quantity, Integer category_id, Integer supplier_id) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category_id = category_id;
        this.supplier_id = supplier_id;
    }

    public Product(int id, String name, String description, double price, int quantity, int category_id, int supplier_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category_id = category_id;
        this.supplier_id = supplier_id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", category_id=" + category_id +
                ", supplier_id=" + supplier_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
