package personagens;

import interfaces.SociedadeDoAnel;
import interfaces.classes.Mago;
import interfaces.racas.Maia;
import personagens.personagem_base.Personagem;
import test.Mapa;

public class Saruman extends Personagem implements Mago, Maia, SociedadeDoAnel {

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
    public Object Ressucitar() {
        return null;
    }

    @Override
    public String falar() {
        return null;
    }

    @Override
    public boolean fazParteDaSociedade() {
        return false;
    }

    @Override
    public void atacar() {
        int posicaoInicial = this.getMapa().buscarPosicao(this);
        Personagem p;
        for(int i = 0; i < this.getMapa().getPersonagens().length; i++){
            p = getMapa().buscarCasa(i);
            if(i != posicaoInicial && p != null && p.fazParteDaSociedade())
                p.setConstituicao((p.getConstituicao()) - (this.inteligencia));

        }
    }

    @Override
    public void avancar() {
        int posicaoInicial = this.getMapa().buscarPosicao(this);
        Personagem p;
        for(int i = 0; i < this.getMapa().getPersonagens().length; i++){
            p = getMapa().buscarCasa(i);
            if(i != posicaoInicial && p != null)
                return;
        }
        this.getMapa().getPersonagens()[getMapa().buscarPosicao(this)] = null;
        this.getMapa().getPersonagens()[posicaoInicial - 1]  = this;
    }

}
