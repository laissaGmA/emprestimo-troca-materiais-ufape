package negocio;

/**
 * Classe responsável por gerenciar todas as funcionalidades do sistema de empréstimo de materiais,
 * como cadastro de usuários, empréstimos, devoluções, avaliações, denúncias e controle de ranking.
 * Atua como núcleo lógico do sistema.
 * 
 * @author Laissa Maria Gama Silva
 */


import dados.RepositorioMaterial;
import dados.RepositorioAvaliacao;
import dados.RepositorioUsuario;
import dados.RepositorioDenuncia;
import java.util.List;

public class SistemaEmprestimo {
    private RepositorioMaterial repositorioMaterial;
    private RepositorioUsuario repositorioUsuario;
    private RepositorioAvaliacao repositorioAvaliacao;
    private RepositorioDenuncia repositorioDenuncia;

    public SistemaEmprestimo() {
        this.repositorioMaterial = new RepositorioMaterial();
        this.repositorioUsuario = new RepositorioUsuario();
        this.repositorioAvaliacao = new RepositorioAvaliacao();
        this.repositorioDenuncia = new RepositorioDenuncia();
    }

    public void adicionarMaterial(Material material) {
        repositorioMaterial.adicionar(material);
    }

    public void registrarUsuario(Usuario usuario) {
        repositorioUsuario.adicionar(usuario);
    }
    
    public List<Usuario> listarUsuarios() {
        return repositorioUsuario.listar();
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

    public void avaliarMaterial(Usuario avaliador, Material material, int nota, String comentario) {
        if (nota < 1 || nota > 5) {
            throw new IllegalArgumentException("Nota deve estar entre 1 e 5.");
        }
        Avaliacao avaliacao = new Avaliacao(avaliador, material, nota, comentario);
        repositorioAvaliacao.adicionarAvaliacao(avaliacao);
    }

    public List<Avaliacao> listarAvaliacoesDeMaterial(Material material) {
        return repositorioAvaliacao.listarAvaliacoesPorMaterial(material);
    }

    public void registrarDenuncia(Usuario denunciante, Usuario denunciado, Material material, String motivo) {
        Denuncia denuncia = new Denuncia(denunciante, denunciado, material, motivo);
        repositorioDenuncia.adicionarDenuncia(denuncia);
    }

    public List<Denuncia> listarDenunciasDeMaterial(Material material) {
        return repositorioDenuncia.listarDenunciasPorMaterial(material);
    }

    public List<Denuncia> listarDenunciasContraUsuario(Usuario usuario) {
        return repositorioDenuncia.listarDenunciasContraUsuario(usuario);
    }
}


