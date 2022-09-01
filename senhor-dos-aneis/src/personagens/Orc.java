package personagens;

import interfaces.SociedadeDoAnel;
import interfaces.classes.Guerreiro;
import interfaces.racas.Monstro;
import personagens.personagem_base.Personagem;
import test.Mapa;

public class Orc extends Personagem implements Guerreiro, Monstro, SociedadeDoAnel {
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
    public String grunir() {
        return null;
    }

    @Override
    public boolean fazParteDaSociedade() {
        return false;
    }

    @Override
    public void atacar() {
        int posicaoInicial = this.getMapa().buscarPosicao(this);
        Personagem p1 = this.getMapa().getPersonagens()[posicaoInicial - 1];
        if(p1 != null && p1.fazParteDaSociedade()){
            p1.setConstituicao((p1.getConstituicao()) - (this.forca*2));
        }

    }

    @Override
    public void avancar() {
        int posicaoInicial = this.getMapa().buscarPosicao(this);
        Personagem p1 = this.getMapa().buscarCasa(this.getMapa().buscarPosicao(this) - 1);
        if(p1 == null){
            this.getMapa().getPersonagens()[posicaoInicial]  = null;
            this.getMapa().getPersonagens()[posicaoInicial - 1] = this;
        }
    }
}
