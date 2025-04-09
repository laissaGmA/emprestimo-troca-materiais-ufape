package fachada;

import negocio.*;

import java.util.List;

public class Fachada {
    private static SistemaEmprestimo sistema = new SistemaEmprestimo();

    public static void adicionarMaterial(Material material) {
        sistema.adicionarMaterial(material);
    }

    public static void registrarUsuario(Usuario usuario) {
        sistema.registrarUsuario(usuario);
    }
    
    public static List<Usuario> listarUsuarios() {
        return sistema.listarUsuarios();
    }


    public static boolean emprestarMaterial(String matricula, String nomeMaterial) {
        return sistema.emprestarMaterial(matricula, nomeMaterial);
    }

    public static boolean devolverMaterial(String matricula, String nomeMaterial) {
        return sistema.devolverMaterial(matricula, nomeMaterial);
    }

    public static List<Material> listarMateriais() {
        return sistema.listarMateriais();
    }

    public static Material buscarMaterial(String nome) {
        return sistema.buscarMaterial(nome);
    }

    public static Usuario buscarUsuario(String matricula) {
        return sistema.buscarUsuario(matricula);
    }

    public static void aumentarRankingUsuario(String matricula) {
        sistema.aumentarRankingUsuario(matricula);
    }

    public static void diminuirRankingUsuario(String matricula) {
        sistema.diminuirRankingUsuario(matricula);
    }

    public static void avaliarMaterial(String matriculaUsuario, String nomeMaterial, int nota, String comentario) {
        Usuario usuario = sistema.buscarUsuario(matriculaUsuario);
        Material material = sistema.buscarMaterial(nomeMaterial);
        if (usuario != null && material != null) {
            sistema.avaliarMaterial(usuario, material, nota, comentario);
        } else {
            System.out.println("Erro: usuário ou material não encontrado.");
        }
    }

    public static List<Avaliacao> listarAvaliacoesDeMaterial(String nomeMaterial) {
        Material material = sistema.buscarMaterial(nomeMaterial);
        if (material != null) {
            return sistema.listarAvaliacoesDeMaterial(material);
        }
        return null;
    }

    public static void denunciarMaterial(String matriculaDenunciante, String matriculaDenunciado, String nomeMaterial, String motivo) {
        Usuario denunciante = sistema.buscarUsuario(matriculaDenunciante);
        Usuario denunciado = sistema.buscarUsuario(matriculaDenunciado);
        Material material = sistema.buscarMaterial(nomeMaterial);

        if (denunciante != null && denunciado != null && material != null) {
            sistema.registrarDenuncia(denunciante, denunciado, material, motivo);
        } else {
            System.out.println("Erro: usuário(s) ou material não encontrado.");
        }
    }

    public static List<Denuncia> listarDenunciasDeMaterial(String nomeMaterial) {
        Material material = sistema.buscarMaterial(nomeMaterial);
        if (material != null) {
            return sistema.listarDenunciasDeMaterial(material);
        }
        return null;
    }

    public static List<Denuncia> listarDenunciasContraUsuario(String matriculaUsuario) {
        Usuario usuario = sistema.buscarUsuario(matriculaUsuario);
        if (usuario != null) {
            return sistema.listarDenunciasContraUsuario(usuario);
        }
        return null;
    }


    public static void inicializarSistema() {
        try {
            adicionarMaterial(new Livro("Clean Code", "Livro sobre boas práticas de programação", "Robert C. Martin", "Programação"));
            adicionarMaterial(new Apostila("POO Java", "Apostila de programação orientada a objetos", "POO"));

            registrarUsuario(new Usuario("João", "joao@email.com", "123", "senha123"));
            registrarUsuario(new Usuario("Maria", "maria@email.com", "456", "senha456"));

            System.out.println("Sistema inicializado com dados de exemplo.\n");

            System.out.println("--- Usuários cadastrados ---");
            for (Usuario u : sistema.listarUsuarios()) {
                System.out.printf("Usuário: %s (%s) - Matrícula: %s - Ranking: %d\n",
                        u.getNome(), u.getEmail(), u.getMatricula(), u.getRanking());
            }

            System.out.println("\n--- Materiais disponíveis ---");
            for (Material m : sistema.listarMateriais()) {
                System.out.printf("%s: \"%s\" - %s\n",
                        m.getClass().getSimpleName(), m.getNome(), m.getDescricao());
            }

        } catch (Exception e) {
            System.out.println("Erro ao inicializar o sistema: " + e.getMessage());
        }
    }

}



