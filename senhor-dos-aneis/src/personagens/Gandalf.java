package personagens;

import exceptions.PersonagemNaoEncontradoNoMapaException;
import interfaces.SociedadeDoAnel;
import interfaces.classes.Mago;
import interfaces.racas.Maia;
import personagens.personagem_base.Personagem;
import test.Mapa;

public class Gandalf extends Personagem implements Mago, Maia, SociedadeDoAnel {

    {
        this.forca = 2;
        this.agilidade = 3;
        this.inteligencia = 10;
        this.constituicao = 80;
    }

    public Gandalf(Mapa mapa) {
        super(mapa);
    }


    @Override
    public String toString() {
        return "G";
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
        return true;
    }

    @Override
    public void atacar() throws PersonagemNaoEncontradoNoMapaException {
        int posicaoInicial = this.getMapa().buscarPosicao(this);
        Personagem p;
        for(int i = 0; i < this.getMapa().getPersonagens().length; i++){
            p = getMapa().buscarCasa(i);
            if(i != posicaoInicial && p != null && !p.fazParteDaSociedade())
                p.setConstituicao((p.getConstituicao()) - (this.inteligencia));

        }
    }

    @Override
    public void avancar() throws PersonagemNaoEncontradoNoMapaException {
        int posicaoInicial = this.getMapa().buscarPosicao(this);
        Personagem p;
        for(int i = 0; i < this.getMapa().getPersonagens().length; i++){
            p = getMapa().buscarCasa(i);
            if(i != posicaoInicial && p != null)
               return;
        }
        this.getMapa().getPersonagens()[getMapa().buscarPosicao(this)] = null;
        this.getMapa().getPersonagens()[posicaoInicial + 1]  = this;
    }
}
