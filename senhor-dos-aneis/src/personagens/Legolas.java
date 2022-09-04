package personagens;
import personagens.personagem_base.Arqueiro;
import test.Mapa;

public class Legolas extends Arqueiro {
    {
        this.forca = 5;
        this.agilidade = 10;
        this.inteligencia = 6;
        this.constituicao = 80;
    }
    public Legolas(Mapa mapa) {
        super(mapa);
    }

    @Override
    public String toString() {
        return "L";
    }

    @Override
    public boolean fazParteDaSociedade() {
        return true;
    }

}
