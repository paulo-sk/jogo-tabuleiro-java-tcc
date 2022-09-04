package personagens;

import exceptions.PersonagemNaoEncontradoNoMapaException;
import interfaces.SociedadeDoAnel;
import personagens.personagem_base.Guerreiro;
import personagens.personagem_base.Personagem;
import test.Mapa;

public class Orc extends Guerreiro {
    {
        this.forca = 7;
        this.agilidade = 4;
        this.inteligencia = 1;
        this.constituicao = 30;
    }

    public Orc(Mapa mapa) {
        super(mapa);
    }

    @Override
    public String toString() {
        return "O";
    }

    @Override
    public boolean fazParteDaSociedade() {
        return false;
    }

}
