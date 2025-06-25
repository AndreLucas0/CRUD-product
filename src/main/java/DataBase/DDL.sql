TRUNCATE TABLE stock_exit, stock_entry, product, supplier, category RESTART IDENTITY CASCADE; --executar apenas se as tabelas já foram criadas

CREATE TABLE category (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE supplier (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    cnpj VARCHAR(18) UNIQUE NOT NULL
);

CREATE TABLE product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(100) NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    quantity INT NOT NULL,
    id_category INTEGER REFERENCES category(id) ON DELETE CASCADE,
    id_supplier INTEGER REFERENCES supplier(id) ON DELETE CASCADE
);

CREATE TABLE stock_entry (
    id SERIAL PRIMARY KEY,
    id_product INTEGER REFERENCES product(id) ON DELETE CASCADE,
    quantity INT NOT NULL,
    entry_date DATE NOT NULL
);

CREATE TABLE stock_exit (
    id SERIAL PRIMARY KEY,
    id_product INTEGER REFERENCES product(id) ON DELETE CASCADE,
    quantity INT NOT NULL,
    exit_date DATE NOT NULL
);