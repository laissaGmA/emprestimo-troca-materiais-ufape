package iu;

import fachada.Fachada;
import negocio.*;
import java.util.Scanner;
import java.util.List;

public class InterfaceTexto {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1 - Adicionar Material");
            System.out.println("2 - Registrar Usuário");
            System.out.println("3 - Emprestar Material");
            System.out.println("4 - Devolver Material");
            System.out.println("5 - Listar Materiais");
            System.out.println("6 - Buscar Material");
            System.out.println("7 - Aumentar Ranking do Usuário");
            System.out.println("8 - Diminuir Ranking do Usuário");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarMaterial();
                    break;
                case 2:
                    registrarUsuario();
                    break;
                case 3:
                    emprestarMaterial();
                    break;
                case 4:
                    devolverMaterial();
                    break;
                case 5:
                    listarMateriais();
                    break;
                case 6:
                    buscarMaterial();
                    break;
                case 7:
                    alterarRankingUsuario(true);
                    break;
                case 8:
                    alterarRankingUsuario(false);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void adicionarMaterial() {
        System.out.print("Nome do material: ");
        String nome = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Tipo (Livro, Apostila, MaterialDeLaboratorio, EquipamentoEletronico): ");
        String tipo = scanner.nextLine();

        Material material = null;
        switch (tipo.toLowerCase()) {
            case "livro":
                System.out.print("Autor: ");
                String autor = scanner.nextLine();
                System.out.print("Categoria: ");
                String categoria = scanner.nextLine();
                material = new Livro(nome, descricao, autor, categoria);
                break;
            case "apostila":
                System.out.print("Disciplina: ");
                String disciplina = scanner.nextLine();
                material = new Apostila(nome, descricao, disciplina);
                break;
            case "material de laboratorio":
                System.out.print("Laboratório: ");
                String laboratorio = scanner.nextLine();
                material = new MaterialDeLaboratorio(nome, descricao, true, laboratorio);
                break;
            case "equipamento eletronico":
                System.out.print("Marca: ");
                String marca = scanner.nextLine();
                System.out.print("Modelo: ");
                String modelo = scanner.nextLine();
                material = new EquipamentoEletronico(nome, descricao, marca, modelo);
                break;
            default:
                System.out.println("Tipo de material não reconhecido.");
                return;
        }

        Fachada.adicionarMaterial(material);
        System.out.println("Material adicionado com sucesso!");
    }

    private static void registrarUsuario() {
        System.out.print("Nome do usuário: ");
        String nome = scanner.nextLine();
        System.out.print("E-mail: ");
        String email = scanner.nextLine();
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Fachada.registrarUsuario(new Usuario(nome, email, matricula, senha));
        System.out.println("Usuário registrado com sucesso!");
    }

    private static void emprestarMaterial() {
        System.out.print("Matrícula do usuário: ");
        String matricula = scanner.nextLine();
        System.out.print("Nome do material: ");
        String nomeMaterial = scanner.nextLine();

        if (Fachada.emprestarMaterial(matricula, nomeMaterial)) {
            System.out.println("Empréstimo realizado com sucesso!");
        } else {
            System.out.println("Empréstimo não pôde ser realizado.");
        }
    }

    private static void devolverMaterial() {
        System.out.print("Matrícula do usuário: ");
        String matricula = scanner.nextLine();
        System.out.print("Nome do material: ");
        String nomeMaterial = scanner.nextLine();

        if (Fachada.devolverMaterial(matricula, nomeMaterial)) {
            System.out.println("Devolução realizada com sucesso!");
        } else {
            System.out.println("Devolução não pôde ser realizada.");
        }
    }

    private static void listarMateriais() {
        System.out.println("\nLista de Materiais:");
        List<Material> materiais = Fachada.listarMateriais();
        if (materiais.isEmpty()) {
            System.out.println("Nenhum material cadastrado.");
        } else {
            materiais.forEach(m -> System.out.println(m.toString()));
        }
    }

    private static void buscarMaterial() {
        System.out.print("Nome do material: ");
        String nome = scanner.nextLine();
        Material material = Fachada.buscarMaterial(nome);
        if (material != null) {
            System.out.println("Material encontrado: " + material);
        } else {
            System.out.println("Material não encontrado.");
        }
    }

    private static void alterarRankingUsuario(boolean aumentar) {
        System.out.print("Matrícula do usuário: ");
        String matricula = scanner.nextLine();
        Usuario usuario = Fachada.buscarUsuario(matricula);

        if (usuario != null) {
            if (aumentar) {
                Fachada.aumentarRankingUsuario(matricula);
                System.out.println("Ranking do usuário aumentado.");
            } else {
                Fachada.diminuirRankingUsuario(matricula);
                System.out.println("Ranking do usuário diminuído.");
            }
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }
}


