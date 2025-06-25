package test;

import DataBase.ProductDAOImpl;
import classes.Product;
import interfaces.ProductDAO;

import java.util.List;
import java.util.Scanner;

public class ProductCRUD {
    private static Scanner teclado = new Scanner(System.in);
    private static ProductDAO dao = new ProductDAOImpl();

    public static void main(String[] args) {
        int op;
        while (true) {
            menu();
            op = teclado.nextInt();
            if (op == 0) {
                System.out.println("Saindo do sistema.");
                break;
            }
            execute(op);
        }
    }

    public static void execute(int op) {
        switch (op) {
            case 1:
                create();
                break;
            case 2:
                update();
                break;
            case 3:
                list();
                break;
            case 4:
                System.out.println("Digite um nome: ");
                searchByName(teclado.next());
                break;
            case 5:
                delete();
                break;
        }
    }

    private static void create() {
        Product product = new Product();
        System.out.println("Nome: ");
        product.setName(teclado.next());
        System.out.println("Descrição: ");
        product.setDescription(teclado.next());
        System.out.println("Preço: ");
        product.setPrice(teclado.nextDouble());
        System.out.println("Quantidade: ");
        product.setQuantity(teclado.nextInt());
        System.out.println("ID da categoria: ");
        product.setCategory_id(teclado.nextInt());
        System.out.println("ID do fornecedor: ");
        product.setSupplier_id(teclado.nextInt());
        dao.save(product);
    }

    private static void update() {
        System.out.println("Selecione um dos produtos abaixo: ");
        List<Product> products = list();
        Product product = products.get(teclado.nextInt());
        System.out.println("Novo nome ou 0 para manter o mesmo: ");
        String name = teclado.next();
        System.out.println("Nova descrição ou 0 para manter a mesma: ");
        String description = teclado.next();
        System.out.println("Novo preço ou 0 para manter o mesmo:  ");
        double price = teclado.nextDouble();
        System.out.println("Nova quantidade ou -1 para manter a mesma: ");
        int quantity = teclado.nextInt();
        System.out.println("Nova categoria ou -1 para manter a mesma: ");
        int category = teclado.nextInt();
        System.out.println("Novo fornecedor ou -1 para manter o mesmo: ");
        int supplier = teclado.nextInt();
        if (!name.equals("0")) {
            product.setName(name);
        }
        if (!description.equals("0")) {
            product.setDescription(name);
        }
        if (!(price == 0.0)) {
            product.setPrice(price);
        }
        if (!(quantity < 0)) {
            product.setQuantity(quantity);
        }
        if (!(category <= 0)) {
            product.setCategory_id(category);
        }
        if (!(supplier <= 0)) {
            product.setSupplier_id(supplier);
        }
        dao.update(product);
    }

    private static List<Product> list() {
        List<Product> products = dao.selectAll();
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.println("[" + i + "] " + product.getName() + " " + product.getDescription() + " " + product.getPrice() + " " + product.getQuantity() + " " + product.getCategory_id() + " " + product.getSupplier_id());
        }
        return products;
    }

    private static List<Product> searchByName(String name) {
        List<Product> products = dao.searchByName(name);
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.println("[" + i + "] " + product.getName() + " " + product.getDescription() + " " + product.getPrice() + " " + product.getQuantity() + " " + product.getCategory_id() + " " + product.getSupplier_id());
        }
        return products;
    }

    private static void delete(){
        System.out.println("Selecione um dos produtos abaixo para deletar: ");
        List<Product> products = list();
        int index = teclado.nextInt();
        System.out.println("Tem certeza? S/N");
        String op = teclado.next();
        if (op.startsWith("S") || op.startsWith("s")) {
            dao.delete(products.get(index));
        } else {
            System.out.println("O produto não será deletado.");
        }
    }

    private static void menu() {
        System.out.println("Digite a opção para começar");
        System.out.println("1. Inserir produto");
        System.out.println("2. Atualizar produto");
        System.out.println("3. Listar todos os produtos");
        System.out.println("4. Buscar produto por nome");
        System.out.println("5. Deletar produto");
        System.out.println("0. Sair");
    }
}
