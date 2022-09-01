package personagens;

import interfaces.SociedadeDoAnel;
import interfaces.classes.Arqueiro;
import interfaces.racas.Monstro;
import personagens.personagem_base.Personagem;
import test.Mapa;

public class Goblim extends Personagem implements Arqueiro, Monstro, SociedadeDoAnel {
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
    public String grunir() {
        return null;
    }

    @Override
    public boolean fazParteDaSociedade() {
        return false;
    }

    @Override
    public void atacar() {
        Personagem p1 = this.getMapa().buscarCasa(this.getMapa().buscarPosicao(this) - 3);
        Personagem p2 = this.getMapa().buscarCasa(this.getMapa().buscarPosicao(this) - 2);
        Personagem p3 = this.getMapa().buscarCasa(this.getMapa().buscarPosicao(this) - 1);
        if(p1 != null && p1.fazParteDaSociedade()){
            p1.setConstituicao(p1.getConstituicao() - (this.agilidade*3));
        }
        else if(p2 != null && p2.fazParteDaSociedade()){
            p1.setConstituicao(p1.getConstituicao() - (this.agilidade*2));
        }
        else if( p3 != null && p3.fazParteDaSociedade()){
            p1.setConstituicao(p1.getConstituicao() - (this.agilidade));
        }
    }

    @Override
    public void avancar() {
        int posicaoInicial = this.getMapa().buscarPosicao(this);
        Personagem p1 = this.getMapa().buscarCasa(this.getMapa().buscarPosicao(this) - 2);
        Personagem p2 = this.getMapa().buscarCasa(this.getMapa().buscarPosicao(this) - 1);
        if(p1 == null && p2 == null){
            this.getMapa().getPersonagens()[getMapa().buscarPosicao(this)] = null;
            this.getMapa().getPersonagens()[posicaoInicial - 2] = this;
        }
        else if(p1 == null && p2 != null){
            this.getMapa().getPersonagens()[getMapa().buscarPosicao(this)] = null;
            this.getMapa().getPersonagens()[posicaoInicial - 1] = this;
        }
    }
}
