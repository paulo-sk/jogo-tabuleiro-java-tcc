package personagens;

import exceptions.PersonagemNaoEncontradoNoMapaException;
import interfaces.SociedadeDoAnel;
import interfaces.classes.Guerreiro;
import interfaces.racas.Humano;
import interfaces.racas.Monstro;
import personagens.personagem_base.Personagem;
import test.Mapa;

public class Urukhai extends Personagem implements Guerreiro, Monstro, Humano, SociedadeDoAnel {
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
    public String grunir() {
        return null;
    }

    @Override
    public boolean fazParteDaSociedade() {
        return false;
    }

    @Override
    public void Envelhecer() {
    }

    @Override
    public String falar() {
        return null;
    }

    @Override
    public void atacar() throws PersonagemNaoEncontradoNoMapaException {
        int posicaoInicial = this.getMapa().buscarPosicao(this);
        Personagem p1 = this.getMapa().getPersonagens()[posicaoInicial - 1];
        if(p1 != null && p1.fazParteDaSociedade()){
            p1.setConstituicao((p1.getConstituicao()) - (this.forca*2));
        }

    }

    @Override
    public void avancar() throws PersonagemNaoEncontradoNoMapaException {
        int posicaoInicial = this.getMapa().buscarPosicao(this);
        Personagem p1 = this.getMapa().buscarCasa(this.getMapa().buscarPosicao(this) - 1);
        if(p1 == null){
            this.getMapa().getPersonagens()[posicaoInicial]  = null;
            this.getMapa().getPersonagens()[posicaoInicial - 1] = this;
        }
    }


}
