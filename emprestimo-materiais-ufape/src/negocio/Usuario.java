package negocio;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa um usuário cadastrado no sistema de empréstimos.
 * Contém informações como nome, e-mail, matrícula, senha e ranking de comportamento.
 * 
 * @author Laissa Maria Gama Silva
 */


public class Usuario {
    private String nome;
    private String email;
    private String matricula;
    private String senha;
    private List<Material> materiaisEmprestados;
    private int ranking; 

    public Usuario(String nome, String email, String matricula, String senha) {
        this.nome = nome;
        this.email = email;
        this.matricula = matricula;
        this.senha = senha;
        this.materiaisEmprestados = new ArrayList<>();
        this.ranking = 0;
    }

    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getMatricula() { return matricula; }
    public boolean verificarSenha(String senha) { return this.senha.equals(senha); }
    public List<Material> getMateriaisEmprestados() { return materiaisEmprestados; }
    public int getRanking() { return ranking; }

    public boolean emprestarMaterial(Material material) {
        if (material.isDisponivel()) {
            materiaisEmprestados.add(material);
            material.setDisponivel(false);
            return true; 
        }
        return false; 
    }
    
    public boolean devolverMaterial(Material material) {
        if (materiaisEmprestados.contains(material)) {
            materiaisEmprestados.remove(material);
            material.setDisponivel(true);
            return true; 
        }
        return false; 
    }

    public void aumentarRanking() { ranking++; }
    public void diminuirRanking() { ranking = Math.max(0, ranking - 1); }

    @Override
    public String toString() {
        return "Usuário: " + nome + " (" + email + ") - Ranking: " + ranking;
    }
}

