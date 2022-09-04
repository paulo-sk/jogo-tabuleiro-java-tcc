package personagens;

import exceptions.PersonagemNaoEncontradoNoMapaException;
import interfaces.SociedadeDoAnel;
import personagens.personagem_base.Guerreiro;
import personagens.personagem_base.Personagem;
import test.Mapa;

public class Boromir extends Guerreiro {
    {
        this.forca = 7;
        this.agilidade = 6;
        this.inteligencia = 3;
        this.constituicao = 40;
    }
    public Boromir(Mapa mapa) {
        super(mapa);
    }
    @Override
    public String toString() {
        return "B";
    }

    @Override
    public boolean fazParteDaSociedade() {
        return true;
    }

}
