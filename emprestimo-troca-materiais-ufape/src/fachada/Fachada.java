package fachada;

import negocio.Material;
import negocio.SistemaEmprestimo;
import negocio.Usuario;
import java.util.List;

public class Fachada {
    private static SistemaEmprestimo sistema = new SistemaEmprestimo();
    
    public static void inicializarSistema() {
        System.out.println("Sistema de empréstimos inicializado com sucesso!");
    }
    
    public static void adicionarMaterial(Material material) {
        sistema.adicionarMaterial(material);
    }

    public static void registrarUsuario(Usuario usuario) {
        sistema.registrarUsuario(usuario);
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
}

