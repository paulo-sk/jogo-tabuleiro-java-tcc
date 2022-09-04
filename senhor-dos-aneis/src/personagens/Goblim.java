package personagens;
import exceptions.PersonagemNaoEncontradoNoMapaException;
import personagens.personagem_base.Arqueiro;
import personagens.personagem_base.Personagem;
import test.Mapa;

public class Goblim extends Arqueiro {
    {
        this.forca = 3;
        this.agilidade = 6;
        this.inteligencia = 1;
        this.constituicao = 20;
    }

    public Goblim(Mapa mapa) {
        super(mapa);
    }

    @Override
    public String toString() {
        return "M";
    }

    @Override
    public boolean fazParteDaSociedade() {
        return false;
    }

}
