package view;

import controller.Teste;

public class Main{
    public static void main(String[] args) {
        Teste teste = new Teste();
        try {
            teste.exec();
        } catch (Exception e ) {
            e.printStackTrace();
        }
    }
}
