package negocio;

/**
 * Classe abstrata que representa um material genérico que pode ser emprestado no sistema,
 * como livros, apostilas ou equipamentos eletrônicos.
 * Contém atributos comuns como nome, descrição e disponibilidade.
 * 
 * @author Laissa Maria Gama Silva
 */

public abstract class Material {
    protected String nome;
    protected String descricao;
    protected boolean disponivel;

    public Material(String nome, String descricao, boolean disponivel) {
        this.nome = nome;
        this.descricao = descricao;
        this.disponivel = disponivel;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return nome + " - " + descricao + " (Disponível: " + disponivel + ")";
    }
}


