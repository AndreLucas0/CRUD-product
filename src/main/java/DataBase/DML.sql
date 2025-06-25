-- Inserindo Categorias
INSERT INTO category (name) VALUES
('Alimentos'),
('Bebidas'),
('Higiene'),
('Limpeza');

-- Inserindo Fornecedores
INSERT INTO supplier (name, cnpj) VALUES
('Fornecedor Alimentos LTDA', '12.345.678/0001-90'),
('Distribuidora Bebidas SA', '23.456.789/0001-01'),
('Fornecedor Higiene ME', '34.567.890/0001-12'),
('Produtos Limpeza EIRELI', '45.678.901/0001-23');

-- Inserindo Produtos
INSERT INTO product (name, description, price, quantity, id_category, id_supplier) VALUES
('Arroz 5kg', 'Pacote de arroz tipo 1', 25.90, 100, 1, 1),
('Feijão 1kg', 'Feijão carioca', 7.50, 80, 1, 1),
('Coca-Cola 2L', 'Refrigerante Coca-Cola', 8.99, 150, 2, 2),
('Sabonete Lux', 'Sabonete perfumado', 2.50, 200, 3, 3),
('Detergente Ypê', 'Detergente líquido 500ml', 3.70, 120, 4, 4);

-- Inserindo Entradas no Estoque
INSERT INTO stock_entry (id_product, quantity, entry_date) VALUES
(1, 50, '2024-06-01'),
(2, 30, '2024-06-02'),
(3, 70, '2024-06-03'),
(4, 100, '2024-06-04'),
(5, 60, '2024-06-05');

-- Inserindo Saídas no Estoque
INSERT INTO stock_exit (id_product, quantity, exit_date) VALUES
(1, 20, '2024-06-06'),
(2, 10, '2024-06-06'),
(3, 40, '2024-06-07'),
(4, 50, '2024-06-08'),
(5, 30, '2024-06-09');
