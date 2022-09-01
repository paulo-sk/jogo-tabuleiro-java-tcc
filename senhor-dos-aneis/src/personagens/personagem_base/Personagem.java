package personagens.personagem_base;

import test.Mapa;

public abstract class Personagem {
    protected Mapa mapa;
    protected int forca;
    protected int agilidade;
    protected int inteligencia;
    protected int constituicao;

    public int getForca() {
        return forca;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public int getConstituicao() {
        return constituicao;
    }

    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public void setConstituicao(int constituicao) {
        this.constituicao = constituicao;
    }

    public Mapa getMapa() {
        return mapa;
    }

    public boolean fazParteDaSociedade() {
        return true;
    }

    public Personagem(Mapa mapa){
        this.mapa = mapa;
    }
    public abstract void atacar();
    public abstract void avancar();
}
