package personagens;

import exceptions.PersonagemNaoEncontradoNoMapaException;
import interfaces.SociedadeDoAnel;
import personagens.personagem_base.Mago;
import personagens.personagem_base.Personagem;
import test.Mapa;

public class Saruman extends Mago {

    {
        this.forca = 2;
        this.agilidade = 2;
        this.inteligencia = 9;
        this.constituicao = 70;
    }

    public Saruman(Mapa mapa) {
        super(mapa);
    }

    @Override
    public String toString() {
        return "S";
    }

    @Override
    public boolean fazParteDaSociedade() {
        return false;
    }

}
