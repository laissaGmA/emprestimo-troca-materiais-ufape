package negocio;

public class Apostila extends Material {
    private String disciplina;

    public Apostila(String nome, String descricao, String disciplina) {
        super(nome, descricao, true); 
        this.disciplina = disciplina;
    }

    public String getDisciplina() {
        return disciplina;
    }

    @Override
    public String toString() {
        return "Apostila: " + nome + " - " + descricao + " (Disciplina: " + disciplina + ", Disponível: " + disponivel + ")";
    }
}


