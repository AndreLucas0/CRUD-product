package interfaces;

import classes.Product;

import java.util.List;

public interface ProductDAO {
    void save(Product product);

    void delete(Product product);

    void update(Product product);

    List<Product> selectAll();

    List<Product> searchByName(String name);
}
