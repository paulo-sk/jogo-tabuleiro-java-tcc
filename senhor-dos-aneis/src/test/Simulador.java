package test;

import exceptions.PersonagemNaoEncontradoNoMapaException;
import exceptions.SauronDominaOMundoException;
import personagens.personagem_base.Personagem;

import java.util.ArrayList;
import java.util.Iterator;

public class Simulador{

    private Mapa mapa;
    public Simulador(Mapa mapa){
        this.mapa = mapa;
    }

    public void simular() throws PersonagemNaoEncontradoNoMapaException, SauronDominaOMundoException {
        boolean gameOver = false;

        while(!gameOver){
            Personagem personagem = null;
            Personagem pRepetido = null;
             for(int i =0; i < mapa.getPersonagens().length; i++){

                 if(mapa.getPersonagens()[i] != null){
                     personagem = mapa.getPersonagens()[i];
                 }

                 if(personagem != null && personagem.equals(pRepetido))
                     continue;

                 if(personagem != null)
                     personagem.atacar();

                /*Depois do ataque do personagem atual, verifica se algum outro personagem do mapa esta
                * com vida <= 0, se tiver, será eliminado para que o personagem atual possa avançar
                * na mesma rodada*/
                 for(int j =0; j < mapa.getPersonagens().length; j++) {
                     if (mapa.getPersonagens()[j] != null && mapa.getPersonagens()[j].getConstituicao() <= 0) {
                         mapa.getPersonagens()[j] = null;
                     }
                 }

                 if(personagem != null)
                    personagem.avancar();

                 //vitoria sociedade do anel
                 if(mapa.buscarCasa(9) != null && mapa.buscarCasa(9).fazParteDaSociedade()){
                     return;
                 }

                int sum= 0;
                for(int j = 0; j < mapa.getPersonagens().length; j++){
                    if(mapa.getPersonagens()[j] == null || !mapa.getPersonagens()[j].fazParteDaSociedade())
                        sum++;
                    if(sum == 10){
                        throw new SauronDominaOMundoException();
                    }
                }

                 pRepetido = personagem;
             }
        }
    }
}
