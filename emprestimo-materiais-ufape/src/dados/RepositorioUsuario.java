package dados;

//Carlos Raiff de Farias Brito

import negocio.Usuario;
import java.util.ArrayList;
import java.util.List;

public class RepositorioUsuario {
    private List<Usuario> usuarios;

    public RepositorioUsuario() {
        this.usuarios = new ArrayList<>();
    }

    public void adicionar(Usuario usuario) {
        usuarios.add(usuario);
    }
    
    public boolean remover(String matricula) {
        return usuarios.removeIf(usuario -> usuario.getMatricula().equals(matricula));
    }



    public List<Usuario> listar() {
        return new ArrayList<>(usuarios);
    }
   

    public Usuario buscar(String matricula) {
        for (Usuario usuario : usuarios) {
            if (usuario.getMatricula().equalsIgnoreCase(matricula)) {
                return usuario;
            }
        }
        return null; 
    }
}

