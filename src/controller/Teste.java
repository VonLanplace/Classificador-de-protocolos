package controller;

import model.*;

public class Teste {
    public Teste(){
        super();
    }

    public void exec() throws Exception{
        ListaCircular lista = new ListaCircular();
        lista.write("https","https");
        lista.write("http","http");
        lista.write("gcc","gcc");
        lista.write("cpp","cpp");
        lista.write("http","http");
        lista.write("https","https");
        lista.write("gcc","gcc");
        lista.write("https","https");
        lista.write("odt","odt");

        System.err.println(lista.toString());
        System.out.println(lista.read("https"));
        System.out.println(lista.read("cpp"));
        System.out.println(lista.read("gcc"));
        System.out.println(lista.read("https"));
        System.err.println(lista.toString());
    }
}
