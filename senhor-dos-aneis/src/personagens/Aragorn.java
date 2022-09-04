package personagens;

import personagens.personagem_base.Guerreiro;

import test.Mapa;

public class Aragorn extends Guerreiro {
    {
        this.forca = 10;
        this.agilidade = 7;
        this.inteligencia = 6;
        this.constituicao = 60;
    }
    public Aragorn(Mapa mapa) {
        super(mapa);
    }

    @Override
    public String toString() {
        return "A";
    }

    @Override
    public boolean fazParteDaSociedade() {
        return true;
    }

}
