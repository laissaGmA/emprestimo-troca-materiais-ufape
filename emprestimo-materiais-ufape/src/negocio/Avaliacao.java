package negocio;

/**
 * Representa uma avaliação feita por um usuário para um material emprestado.
 * Inclui nota, comentário, usuário avaliador e material avaliado.
 * 
 * @author Laissa Maria Gama Silva
 */


public class Avaliacao {
    private Usuario avaliador;
    private Material material;
    private int nota;
    private String comentario;

    public Avaliacao(Usuario avaliador, Material material, int nota, String comentario) {
        this.avaliador = avaliador;
        this.material = material;
        this.nota = nota;
        this.comentario = comentario;
    }

    public Usuario getAvaliador() {
        return avaliador;
    }

    public Material getMaterial() {
        return material;
    }

    public int getNota() {
        return nota;
    }

    public String getComentario() {
        return comentario;
    }

    @Override
    public String toString() {
        return "Avaliação{" +
                "avaliador=" + avaliador.getNome() +
                ", material=" + material.getNome() +
                ", nota=" + nota +
                ", comentário='" + comentario + '\'' +
                '}';
    }
}
