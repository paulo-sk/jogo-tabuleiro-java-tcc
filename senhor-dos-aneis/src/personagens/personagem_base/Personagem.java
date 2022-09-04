package personagens.personagem_base;

import exceptions.PersonagemNaoEncontradoNoMapaException;
import interfaces.SociedadeDoAnel;
import test.Mapa;

public  abstract class Personagem implements SociedadeDoAnel {
    protected Mapa mapa;
    protected int forca;
    protected int agilidade;
    protected int inteligencia;
    protected int constituicao;
    public int getConstituicao() {
        return constituicao;
    }
    public void setConstituicao(int constituicao) {
        this.constituicao = constituicao;
    }

    public Mapa getMapa() {
        return mapa;
    }
    public Personagem(Mapa mapa){
        this.mapa = mapa;
    }
    public abstract void atacar() throws PersonagemNaoEncontradoNoMapaException;
    public abstract void avancar() throws PersonagemNaoEncontradoNoMapaException;

}
