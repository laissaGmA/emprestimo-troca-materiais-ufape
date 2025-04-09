package dados;

//Carlos Raiff de Farias Brito

import negocio.Denuncia;
import negocio.Material;
import negocio.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDenuncia {
    private List<Denuncia> denuncias;

    public RepositorioDenuncia() {
        this.denuncias = new ArrayList<>();
    }

    public void adicionarDenuncia(Denuncia denuncia) {
        denuncias.add(denuncia);
    }

    public List<Denuncia> listarDenunciasPorMaterial(Material material) {
        return denuncias.stream()
                .filter(d -> d.getMaterial().equals(material))
                .collect(Collectors.toList());
    }

    public List<Denuncia> listarDenunciasContraUsuario(Usuario usuario) {
        return denuncias.stream()
                .filter(d -> d.getDenunciado().equals(usuario))
                .collect(Collectors.toList());
    }

    public List<Denuncia> listarTodasDenuncias() {
        return new ArrayList<>(denuncias);
    }
}
