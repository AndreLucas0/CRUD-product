package DataBase;

import classes.Product;
import connection.DataBaseConnection;
import interfaces.ProductDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    private static String sql;

    @Override
    public void save(Product product) {
        String sql = "INSERT INTO product (name, description, price, quantity, id_category, id_supplier) VALUES (?, ?, ?, ?, ?, ?);";
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setDouble(3, product.getPrice());
            ps.setInt(4, product.getQuantity());
            ps.setInt(5, product.getCategory_id());
            ps.setInt(6, product.getSupplier_id());
            ps.executeUpdate();
            System.out.println("Registro inserido com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Product product) {
        if (product == null) {
            System.out.println("Não foi possível excluir o registro.");
            return;
        }
        String sql = "DELETE FROM product WHERE id=?;";
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, product.getId());
            ps.executeUpdate();
            System.out.println("Registro excluido com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Product product) {
        if (product == null) {
            System.out.println("Não foi possível atualizar o registro.");
            return;
        }
        String sql = "UPDATE product SET name=?,  description=?, price=?, quantity=?, id_category=?, id_supplier=? WHERE id=?;";
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setDouble(3, product.getPrice());
            ps.setInt(4, product.getQuantity());
            ps.setInt(5, product.getCategory_id());
            ps.setInt(6, product.getSupplier_id());
            ps.setInt(7, product.getId());
            ps.executeUpdate();
            System.out.println("Registro atualizado com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> selectAll() {
        String sql = "SELECT * FROM product ORDER BY id;";
        List<Product> products = new ArrayList<>();
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();) {

            while (rs.next()) {
                products.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs.getDouble("price"), rs.getInt("quantity"), rs.getInt("id_category"), rs.getInt("id_supplier")));
            }
            return products;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> searchByName(String name) {
        String sql = "SELECT * FROM product WHERE name LIKE ? ORDER BY id;";
        List<Product> products = new ArrayList<>();
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
        ) {
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                products.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs.getDouble("price"), rs.getInt("quantity"), rs.getInt("id_category"), rs.getInt("id_supplier")));
            }
            DataBaseConnection.close(connection, ps, rs);
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
