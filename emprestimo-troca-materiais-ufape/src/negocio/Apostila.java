package negocio;

/**
 * Representa uma apostila de estudos disponível no sistema de empréstimos.
 * Herda os atributos de Material e inclui a disciplina relacionada.
 * 
 * @author Laissa Maria Gama Silva
 */


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


