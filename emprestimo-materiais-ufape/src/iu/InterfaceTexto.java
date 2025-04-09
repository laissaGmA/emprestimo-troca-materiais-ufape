package iu;

import fachada.Fachada;
import negocio.*;

import java.util.List;
import java.util.Scanner;

public class InterfaceTexto {
    
    public void executar() {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n========== SISTEMA DE EMPRÉSTIMO DE MATERIAIS ==========");
            System.out.println("1. Listar materiais disponíveis");
            System.out.println("2. Registrar novo usuário");
            System.out.println("3. Emprestar material");
            System.out.println("4. Devolver material");
            System.out.println("5. Avaliar material");
            System.out.println("6. Ver avaliações de um material");
            System.out.println("7. Denunciar usuário");
            System.out.println("8. Ver denúncias contra usuário");
            System.out.println("9. Aumentar ranking de usuário");
            System.out.println("10. Diminuir ranking de usuário");
            System.out.println("11. Buscar material");
            System.out.println("12. Buscar usuário");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    listarMateriais();
                    break;
                case 2:
                    registrarUsuario(scanner);
                    break;
                case 3:
                    emprestarMaterial(scanner);
                    break;
                case 4:
                    devolverMaterial(scanner);
                    break;
                case 5:
                    avaliarMaterial(scanner);
                    break;
                case 6:
                    listarAvaliacoes(scanner);
                    break;
                case 7:
                    denunciarUsuario(scanner);
                    break;
                case 8:
                    listarDenunciasContraUsuario(scanner);
                    break;
                case 9:
                    alterarRanking(scanner, true);
                    break;
                case 10:
                    alterarRanking(scanner, false);
                    break;
                case 11:
                    buscarMaterial(scanner);
                    break;
                case 12:
                    buscarUsuario(scanner);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();

    }

    private static void listarMateriais() {
        List<Material> materiais = Fachada.listarMateriais();
        System.out.println("\n--- Materiais Disponíveis ---");
        if (materiais.isEmpty()) {
            System.out.println("Nenhum material cadastrado.");
        } else {
            for (Material material : materiais) {
                System.out.println(material);
            }
        }
    }

    private static void registrarUsuario(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Usuario usuario = new Usuario(nome, email, matricula, senha);
        Fachada.registrarUsuario(usuario);
        System.out.println("Usuário registrado com sucesso!");
    }

    private static void emprestarMaterial(Scanner scanner) {
        System.out.print("Matrícula do usuário: ");
        String matricula = scanner.nextLine();
        System.out.print("Nome do material: ");
        String nomeMaterial = scanner.nextLine();

        boolean sucesso = Fachada.emprestarMaterial(matricula, nomeMaterial);
        if (sucesso) {
            System.out.println("Empréstimo realizado com sucesso.");
        } else {
            System.out.println("Erro ao realizar empréstimo.");
        }
    }

    private static void devolverMaterial(Scanner scanner) {
        System.out.print("Matrícula do usuário: ");
        String matricula = scanner.nextLine();
        System.out.print("Nome do material: ");
        String nomeMaterial = scanner.nextLine();

        boolean sucesso = Fachada.devolverMaterial(matricula, nomeMaterial);
        if (sucesso) {
            System.out.println("Material devolvido com sucesso.");
        } else {
            System.out.println("Erro ao devolver material.");
        }
    }

    private static void avaliarMaterial(Scanner scanner) {
        System.out.print("Matrícula do usuário: ");
        String matricula = scanner.nextLine();
        System.out.print("Nome do material: ");
        String nomeMaterial = scanner.nextLine();
        System.out.print("Nota (1 a 5): ");
        int nota = Integer.parseInt(scanner.nextLine());
        System.out.print("Comentário: ");
        String comentario = scanner.nextLine();

        Fachada.avaliarMaterial(matricula, nomeMaterial, nota, comentario);
        System.out.println("Avaliação registrada.");
    }

    private static void listarAvaliacoes(Scanner scanner) {
        System.out.print("Nome do material: ");
        String nomeMaterial = scanner.nextLine();

        List<Avaliacao> avaliacoes = Fachada.listarAvaliacoesDeMaterial(nomeMaterial);
        if (avaliacoes == null || avaliacoes.isEmpty()) {
            System.out.println("Nenhuma avaliação encontrada.");
        } else {
            System.out.println("--- Avaliações ---");
            for (Avaliacao av : avaliacoes) {
                System.out.println(av);
            }
        }
    }

    private static void denunciarUsuario(Scanner scanner) {
        System.out.print("Matrícula do denunciante: ");
        String matriculaDenunciante = scanner.nextLine();
        System.out.print("Matrícula do denunciado: ");
        String matriculaDenunciado = scanner.nextLine();
        System.out.print("Nome do material envolvido: ");
        String nomeMaterial = scanner.nextLine();
        System.out.print("Motivo da denúncia: ");
        String motivo = scanner.nextLine();

        Fachada.denunciarMaterial(matriculaDenunciante, matriculaDenunciado, nomeMaterial, motivo);
        System.out.println("Denúncia registrada.");
    }

    private static void listarDenunciasContraUsuario(Scanner scanner) {
        System.out.print("Matrícula do usuário denunciado: ");
        String matricula = scanner.nextLine();

        List<Denuncia> denuncias = Fachada.listarDenunciasContraUsuario(matricula);
        if (denuncias == null || denuncias.isEmpty()) {
            System.out.println("Nenhuma denúncia encontrada.");
        } else {
            System.out.println("--- Denúncias ---");
            for (Denuncia d : denuncias) {
                System.out.println(d);
            }
        }
    }

    private static void alterarRanking(Scanner scanner, boolean aumentar) {
        System.out.print("Matrícula do usuário: ");
        String matricula = scanner.nextLine();

        if (aumentar) {
            Fachada.aumentarRankingUsuario(matricula);
            System.out.println("Ranking aumentado.");
        } else {
            Fachada.diminuirRankingUsuario(matricula);
            System.out.println("Ranking diminuído.");
        }
    }

    private static void buscarMaterial(Scanner scanner) {
        System.out.print("Nome do material: ");
        String nome = scanner.nextLine();

        Material m = Fachada.buscarMaterial(nome);
        if (m != null) {
            System.out.println("Material encontrado: " + m);
        } else {
            System.out.println("Material não encontrado.");
        }
    }

    private static void buscarUsuario(Scanner scanner) {
        System.out.print("Matrícula do usuário: ");
        String matricula = scanner.nextLine();

        Usuario u = Fachada.buscarUsuario(matricula);
        if (u != null) {
            System.out.println("Usuário encontrado: " + u);
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }
}


