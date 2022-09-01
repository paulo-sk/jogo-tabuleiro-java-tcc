package personagens;

import interfaces.SociedadeDoAnel;
import interfaces.classes.Guerreiro;
import interfaces.racas.Humano;
import personagens.personagem_base.Personagem;
import test.Mapa;

public class Bromir extends Personagem implements Guerreiro, Humano, SociedadeDoAnel {
    {
        this.forca = 7;
        this.agilidade = 6;
        this.inteligencia = 3;
        this.constituicao = 40;
    }

    public Bromir(Mapa mapa) {
        super(mapa);
    }


    @Override
    public String toString() {
        return "B";
    }

    @Override
    public void Envelhecer() {

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
        Personagem p1 = this.getMapa().buscarCasa(this.getMapa().buscarPosicao(this) + 1);
        if(p1 != null && !p1.fazParteDaSociedade()){
            p1.setConstituicao(p1.getConstituicao() - (this.forca*2));
        }

    }

    @Override
    public void avancar() {
        int posicaoInicial = this.getMapa().buscarPosicao(this);
        Personagem p1 = this.getMapa().buscarCasa(this.getMapa().buscarPosicao(this) + 1);
        if(p1 == null){
            this.getMapa().getPersonagens()[getMapa().buscarPosicao(this)] = null;
            this.getMapa().getPersonagens()[posicaoInicial + 1]  = this;
        }
    }
}
