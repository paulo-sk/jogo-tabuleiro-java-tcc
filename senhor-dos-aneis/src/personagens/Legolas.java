package personagens;

import interfaces.SociedadeDoAnel;
import interfaces.classes.Arqueiro;
import interfaces.racas.Elfo;
import personagens.personagem_base.Personagem;
import test.Mapa;

public class Legolas extends Personagem implements Arqueiro, Elfo, SociedadeDoAnel {
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
    public String falarElfico() {
        return null;
    }

    @Override
    public String falar() {
        return null;
    }

    @Override
    public boolean fazParteDaSociedade() {
        return true;
    }

    @Override
    public void atacar() {
        Personagem p1 = this.getMapa().buscarCasa(this.getMapa().buscarPosicao(this) + 3);
        Personagem p2 = this.getMapa().buscarCasa(this.getMapa().buscarPosicao(this) + 2);
        Personagem p3 = this.getMapa().buscarCasa(this.getMapa().buscarPosicao(this) + 1);
        if(p1 != null && !p1.fazParteDaSociedade()){
            p1.setConstituicao(p1.getConstituicao() - (this.agilidade*3));
        }
        else if(p2 != null && !p2.fazParteDaSociedade()){
            p1.setConstituicao(p1.getConstituicao() - (this.agilidade*2));
        }
        else if( p3 != null && !p3.fazParteDaSociedade()){
            p1.setConstituicao(p1.getConstituicao() - (this.agilidade));
        }
    }

    @Override
    public void avancar() {
        int posicaoInicial = this.getMapa().buscarPosicao(this);
        Personagem p1 = this.getMapa().buscarCasa(this.getMapa().buscarPosicao(this) + 2);
        Personagem p2 = this.getMapa().buscarCasa(this.getMapa().buscarPosicao(this) + 1);
        if(p1 == null && p2 == null){
            this.getMapa().getPersonagens()[getMapa().buscarPosicao(this)] = null;
            this.getMapa().getPersonagens()[posicaoInicial + 2] = this;

        }
        else if(p1 == null && p2 != null){
            this.getMapa().getPersonagens()[getMapa().buscarPosicao(this)] = null;
            this.getMapa().getPersonagens()[posicaoInicial + 1] = this;
        }
    }
}
