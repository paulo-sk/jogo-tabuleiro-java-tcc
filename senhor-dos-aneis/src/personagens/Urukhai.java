package personagens;

import exceptions.PersonagemNaoEncontradoNoMapaException;
import personagens.personagem_base.Guerreiro;
import personagens.personagem_base.Personagem;
import test.Mapa;

public class Urukhai extends Guerreiro {
    {
        this.forca = 8;
        this.agilidade = 6;
        this.inteligencia = 3;
        this.constituicao = 45;
    }

    public Urukhai(Mapa mapa) {
        super(mapa);
    }
    @Override
    public String toString() {
        return "U";
    }
    @Override
    public boolean fazParteDaSociedade() {
        return false;
    }

}
