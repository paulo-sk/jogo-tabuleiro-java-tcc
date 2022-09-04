package personagens;

import exceptions.PersonagemNaoEncontradoNoMapaException;
import interfaces.SociedadeDoAnel;
import personagens.personagem_base.Mago;
import personagens.personagem_base.Personagem;
import test.Mapa;

public class Gandalf extends Mago {

    {
        this.forca = 2;
        this.agilidade = 3;
        this.inteligencia = 10;
        this.constituicao = 80;
    }

    public Gandalf(Mapa mapa) {
        super(mapa);
    }

    @Override
    public String toString() {
        return "G";
    }


    @Override
    public boolean fazParteDaSociedade() {
        return true;
    }

}
