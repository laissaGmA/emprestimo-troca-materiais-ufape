package dados;

import negocio.Avaliacao;
import negocio.Material;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioAvaliacao {
    private List<Avaliacao> avaliacoes;

    public RepositorioAvaliacao() {
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

