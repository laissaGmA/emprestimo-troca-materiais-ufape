
# 📚 Sistema de Empréstimo de Materiais - UFAPE

Este é um sistema acadêmico para **empréstimo de materiais** como livros, apostilas, equipamentos eletrônicos e materiais de laboratório entre estudantes da **UFAPE**. O sistema é acessado via interface de texto (console) e permite a gestão de usuários, materiais, empréstimos, avaliações e denúncias.

> Desenvolvido como projeto de Programação Orientada a Objetos.

---

## 📌 Funcionalidades

✅ Registro e autenticação de usuários  
✅ Cadastro de materiais (livros, apostilas, eletrônicos e laboratoriais)  
✅ Empréstimo e devolução de materiais  
✅ Avaliação de materiais com comentários e notas  
✅ Registro de denúncias contra usuários  
✅ Sistema de ranking baseado no comportamento dos usuários  
✅ Listagem e busca de usuários e materiais  
✅ Interface simples via console  
✅ Padrão de projeto Fachada  
✅ Organização em camadas  
✅ Testes automatizados com JUnit  
✅ Diagrama UML do sistema

---

## 🧱 Estrutura do Projeto

```
emprestimo-materiais-ufape/
│
├── src/
│   ├── dados/            # Repositórios
│   ├── negocio/          # Lógica de negócio
│   ├── fachada/          # Classe Fachada
│   ├── iu/               # Interface de usuário (console)
│   └── main/             # Classe de inicialização (Application.java)
│
├── test/                 # Testes unitários e de integração
│
├── README.md             # Este arquivo
```

---

## 🧠 Conceitos de POO Aplicados

- ✅ **Classe e Objeto**
- ✅ **Atributos e Métodos**
- ✅ **Encapsulamento**
- ✅ **Associação entre classes**
- ✅ **Herança** (`Material` e suas subclasses)
- ✅ **Polimorfismo**
- ✅ **Interface via console**
- ✅ **Exceções (biblioteca e personalizadas)**
- ✅ **Padrão de projeto Fachada**
- ✅ **Organização em camadas** (`negocio`, `dados`, `fachada`, `iu`)

---

## 💡 Tecnologias Utilizadas

- Java 17
- Spring Tool Suite 4 (STS)
- JUnit 5
- Visual Paradigm (para o UML)
- PlantUML (diagrama de classes)
- Git e GitHub

---

## 🔎 Exemplo de Uso

```bash
1. Inicie o sistema com a classe Application.java
2. Escolha uma das opções do menu:
   [1] Registrar usuário
   [2] Adicionar material
   [3] Emprestar material
   [4] Avaliar material
   [5] Registrar denúncia
   ...
```

---

## 🧪 Testes

Os testes estão localizados no diretório `test/` e cobrem:
- Operações de repositórios
- Cadastro e busca de usuários/materiais
- Avaliação e denúncias

Execute com JUnit na sua IDE ou via Maven.

---

## 👩‍💻 Autoria

**Laissa Maria Gama Silva**  
Estudante de Ciência da Computação - UFAPE.

---

## 📄 Licença

Este projeto é de uso acadêmico e educacional.

---
