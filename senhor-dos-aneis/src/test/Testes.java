package test;

import personagens.*;

public class Testes {
    public static void main(String[] args) {
        Mapa mapa = new Mapa();

        Aragorn aragorn = new Aragorn(mapa);
        Legolas legolas = new Legolas(mapa);
        Orc orc = new Orc(mapa);
        Goblim goblim = new Goblim(mapa);

        mapa.inserir(0, aragorn);
        //mapa.inserir(1, legolas);
        mapa.inserir(7, orc);
        //mapa.inserir(9, goblim);


        Simulador simulador = new Simulador(mapa);
        simulador.simular();
        System.out.println(mapa.exibir());





    }
}
