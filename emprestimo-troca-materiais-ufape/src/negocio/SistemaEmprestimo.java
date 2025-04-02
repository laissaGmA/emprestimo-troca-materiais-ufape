package negocio;

import dados.RepositorioMaterial;
import dados.RepositorioUsuario;
import java.util.List;

public class SistemaEmprestimo {
    private RepositorioMaterial repositorioMaterial;
    private RepositorioUsuario repositorioUsuario;

    public SistemaEmprestimo() {
        this.repositorioMaterial = new RepositorioMaterial();
        this.repositorioUsuario = new RepositorioUsuario();
    }

    public void adicionarMaterial(Material material) {
        repositorioMaterial.adicionar(material);
    }

    public void registrarUsuario(Usuario usuario) {
        repositorioUsuario.adicionar(usuario);
    }

    public boolean emprestarMaterial(String matricula, String nomeMaterial) {
        Usuario usuario = repositorioUsuario.buscar(matricula);
        Material material = repositorioMaterial.buscar(nomeMaterial);

        if (usuario != null && material != null && material.isDisponivel()) {
            usuario.emprestarMaterial(material);
            return true;
        }
        return false;
    }

    public boolean devolverMaterial(String matricula, String nomeMaterial) {
        Usuario usuario = repositorioUsuario.buscar(matricula);
        Material material = repositorioMaterial.buscar(nomeMaterial);

        if (usuario != null && material != null && usuario.getMateriaisEmprestados().contains(material)) {
            usuario.devolverMaterial(material);
            return true;
        }
        return false;
    }

    public List<Material> listarMateriais() {
        return repositorioMaterial.listarTodos();
    }

    public Material buscarMaterial(String nome) {
        return repositorioMaterial.buscar(nome);
    }

    public Usuario buscarUsuario(String matricula) {
        return repositorioUsuario.buscar(matricula);
    }

    public void aumentarRankingUsuario(String matricula) {
        Usuario usuario = repositorioUsuario.buscar(matricula);
        if (usuario != null) {
            usuario.aumentarRanking();
        }
    }

    public void diminuirRankingUsuario(String matricula) {
        Usuario usuario = repositorioUsuario.buscar(matricula);
        if (usuario != null) {
            usuario.diminuirRanking();
        }
    }
}

