package personagens;

import exceptions.PersonagemNaoEncontradoNoMapaException;
import interfaces.SociedadeDoAnel;
import personagens.personagem_base.Guerreiro;
import personagens.personagem_base.Personagem;
import test.Mapa;

public class Gimli extends Guerreiro {
    {
        this.forca = 9;
        this.agilidade = 2;
        this.inteligencia = 4;
        this.constituicao = 60;
    }

    public Gimli(Mapa mapa) {
        super(mapa);
    }
    @Override
    public String toString() {
        return "I";
    }

    @Override
    public boolean fazParteDaSociedade() {
        return true;
    }

}
