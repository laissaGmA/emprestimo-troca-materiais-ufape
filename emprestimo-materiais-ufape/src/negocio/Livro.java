package negocio;

/**
 * Representa um livro disponível para empréstimo no sistema.
 * Herda atributos de Material e adiciona autor e categoria.
 * 
 * @author Laissa Maria Gama Silva
 */


public class Livro extends Material {
    private String autor;
    private String categoria;

    public Livro(String nome, String descricao, String autor, String categoria) {
        super(nome, descricao, true); 
        this.autor = autor;
        this.categoria = categoria;
    }

    public String getAutor() { return autor; }
    public String getCategoria() { return categoria; }
    
    @Override
    public String toString() {
        return "Livro: " + nome + " - " + descricao + " (Autor: " + autor + ", Categoria: " + categoria + ", Disponível: " + disponivel + ")";
    }
}
