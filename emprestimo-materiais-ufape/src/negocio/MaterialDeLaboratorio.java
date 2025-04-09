package negocio;

/**
 * Representa um material de laboratório que pode ser emprestado no sistema.
 * Herda de Material e contém informações sobre o tipo de material laboratorial.
 * 
 * Carlos Raiff de Farias Brito
 */


public class MaterialDeLaboratorio extends Material {
    private String laboratorio;

    public MaterialDeLaboratorio(String nome, String descricao, boolean disponivel, String laboratorio) {
        super(nome, descricao, disponivel);
        this.laboratorio = laboratorio;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    @Override
    public String toString() {
        return "Material de Laboratório: " + nome + " - " + descricao + " (Laboratório: " + laboratorio + ", Disponível: " + disponivel + ")";
    }
}

