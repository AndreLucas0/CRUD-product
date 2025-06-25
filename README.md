# 🛒 Sistema de Gerenciamento de Produtos (CRUD com Java e PostgreSQL)

Este projeto é um sistema simples de gerenciamento de produtos com interface via terminal. Ele implementa operações CRUD completas utilizando Java, PostgreSQL e JDBC, com foco em boas práticas de desenvolvimento e arquitetura.

---

## 📋 Funcionalidades

- ✅ Inserir novos produtos no banco de dados
- ✏️ Atualizar dados de produtos existentes
- 🔍 Buscar produto por nome
- 📄 Listar todos os produtos
- 🗑️ Excluir produto por ID
- 💾 Persistência com PostgreSQL via JDBC

---

## 🧰 Tecnologias utilizadas

| Tecnologia   | Descrição                             |
|--------------|-----------------------------------------|
| Java         | Lógica de negócio, terminal e JDBC       |
| PostgreSQL   | Banco de dados relacional                |
| JDBC         | Conexão com banco e execução de SQL      |
| DAO Pattern  | Separação de lógica de acesso a dados    |
| OOP          | Programação orientada a objetos          |

---

## 🗃️ Estrutura do Projeto

/src<br>
├── connection/<br>
│ └── DataBaseConnection.java # Classe Singleton para gerenciar conexões<br>
├── classes/<br>
│ └── Product.java # Classe modelo de Produto<br>
├── DataBase/<br>
│ └── ProductDAOImpl.java # Implementação DAO com operações CRUD<br>
└── test/<br>
└── TestCRUD.java # Interface via terminal com menu interativo<br>

---

## 🧠 Aprendizados
Durante o desenvolvimento, enfrentei e corrigi um problema comum com conexões JDBC: "This connection has been closed", causado por reuso indevido de uma única conexão persistente. A refatoração para obter uma nova conexão a cada operação melhorou muito a confiabilidade e escalabilidade do sistema.

Também apliquei boas práticas como:

- Uso de try-with-resources;
- Isolamento de responsabilidades via DAO;
- Manipulação de entrada do usuário com validação;

---

## Contribuição
Sinta-se à vontade para abrir issues, propor melhorias ou enviar pull requests.

---

## Autor
Desenvolvido por André Lucas Ferreira.

