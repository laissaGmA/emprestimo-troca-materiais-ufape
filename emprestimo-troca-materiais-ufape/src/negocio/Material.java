package negocio;

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


