package main;

import fachada.Fachada;
import iu.InterfaceTexto;

public class Application {
    public static void main(String[] args) {
        System.out.println("Iniciando o sistema de empréstimos...");
        
        
        Fachada.inicializarSistema();

        InterfaceTexto.main(args);
    }
}
