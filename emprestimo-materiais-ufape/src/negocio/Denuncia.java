package negocio;

/**
 * Representa uma denúncia feita por um usuário contra outro, relacionada a um material emprestado.
 * Armazena o denunciante, o denunciado, o material e o motivo da denúncia.
 * 
 * @author Laissa Maria Gama Silva
 */


public class Denuncia {
    private Usuario denunciante;
    private Usuario denunciado;
    private Material material;
    private String motivo;

    public Denuncia(Usuario denunciante, Usuario denunciado, Material material, String motivo) {
        this.denunciante = denunciante;
        this.denunciado = denunciado;
        this.material = material;
        this.motivo = motivo;
    }

    public Usuario getDenunciante() {
        return denunciante;
    }

    public Usuario getDenunciado() {
        return denunciado;
    }

    public Material getMaterial() {
        return material;
    }

    public String getMotivo() {
        return motivo;
    }

    @Override
    public String toString() {
        return "Denúncia{" +
                "denunciante=" + denunciante.getNome() +
                ", denunciado=" + denunciado.getNome() +
                ", material=" + material.getNome() +
                ", motivo='" + motivo + '\'' +
                '}';
    }
}

