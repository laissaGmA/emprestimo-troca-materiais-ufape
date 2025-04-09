package repositorio;

import negocio.Avaliacao;
import negocio.Material;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioAvaliacaoTest {
    private List<Avaliacao> avaliacoes;

    public RepositorioAvaliacaoTest() {
        this.avaliacoes = new ArrayList<>();
    }

    public void adicionarAvaliacao(Avaliacao avaliacao) {
        avaliacoes.add(avaliacao);
    }

    public List<Avaliacao> listarAvaliacoesPorMaterial(Material material) {
        return avaliacoes.stream()
                .filter(a -> a.getMaterial().equals(material))
                .collect(Collectors.toList());
    }

    public List<Avaliacao> listarTodasAvaliacoes() {
        return new ArrayList<>(avaliacoes);
    }
}

