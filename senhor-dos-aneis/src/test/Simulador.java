package test;

import exceptions.PersonagemNaoEncontradoNoMapaException;
import exceptions.SauronDominaOMundoException;
import interfaces.SociedadeDoAnel;
import interfaces.classes.Arqueiro;
import interfaces.classes.Guerreiro;
import interfaces.classes.Mago;
import personagens.personagem_base.Personagem;

import java.util.ArrayList;

public class Simulador{

    private Mapa mapa;
    public Simulador(Mapa mapa){
        this.mapa = mapa;
    }

    public void simular() throws PersonagemNaoEncontradoNoMapaException {
        boolean gameOver = false;
        Personagem p;
        while(!gameOver){
            for(int i = 0; i < mapa.getPersonagens().length ; i++){
                p = mapa.getPersonagens()[i];
                if(p != null && p.getConstituicao() <= 0){
                    mapa.getPersonagens()[i] = null;
                }

                //vitoria sociedade do anel
                if(mapa.buscarCasa(9) != null && mapa.buscarCasa(9).fazParteDaSociedade()){
                    System.out.println("Vitoria da sociedade do anel");
                    return;
                }
                //vitoria saruman
                int sum= 0;
                for(int j = 0; j < mapa.getPersonagens().length; j++){
                    if(mapa.getPersonagens()[j] == null || !mapa.getPersonagens()[j].fazParteDaSociedade())
                        sum++;
                    if(sum >= 10){
                        System.out.println("sauron venceu");
                        return;
                    }
                }

                //enquanto o game rodar
                if (p != null) {
                    p.atacar();
                    p.avancar();

                }

            }

        }
    }


    public void simular2() throws PersonagemNaoEncontradoNoMapaException, SauronDominaOMundoException {
        boolean gameOver = false;

        while(!gameOver){
            Personagem personagem = null;
            Personagem pRepetido = null;

             for(int i =0; i < mapa.getPersonagens().length; i++){
                 if(mapa.getPersonagens()[i] != null)
                      personagem = mapa.getPersonagens()[i];

                 //se personagem tiver sem  vida, sai do mapa;
                 if(personagem != null && personagem.getConstituicao() <= 0){
                     mapa.getPersonagens()[i] = null;
                     continue;
                 }

                 //vitoria sociedade do anel
                 if(mapa.buscarCasa(9) != null && mapa.buscarCasa(9).fazParteDaSociedade()){
                     System.out.println("Vitoria da sociedade do anel");
                     return;
                 }
                try{
                    int sum= 0;
                    for(int j = 0; j < mapa.getPersonagens().length; j++){
                        if(mapa.getPersonagens()[j] == null || !mapa.getPersonagens()[j].fazParteDaSociedade())
                            sum++;
                        if(sum == 10)
                          throw new SauronDominaOMundoException();

                    }
                }catch (SauronDominaOMundoException e){
                    e.printStackTrace();
                    return;
                }

                 if(personagem != null && personagem.equals(pRepetido)){
                     continue;
                 }

                 if(personagem != null){
                     personagem.atacar();
                     personagem.avancar();
                 }
                 pRepetido = personagem;
             }
        }
    }

    public void simular3() throws PersonagemNaoEncontradoNoMapaException {
        ArrayList<Personagem> personagens = new ArrayList<Personagem>();

        for(Personagem p: mapa.getPersonagens()){
            if(p != null)
                personagens.add(p);
        }
        boolean gameOn = true;

        while (gameOn){
            System.out.println(mapa.exibir());

            //vitoria sociedade do anel
            if(mapa.buscarCasa(9) != null && mapa.buscarCasa(9).fazParteDaSociedade()){
                System.out.println("Vitoria da sociedade do anel");
                gameOn = false;
                return;
            }

            for (Personagem p: mapa.getPersonagens()){
                if(p != null && p.getConstituicao() <= 0){
                    mapa.getPersonagens()[mapa.buscarPosicao(p)] = null;
                    personagens.remove(p);
                }
            }


            int sum= 0;
            for(int j = 0; j < mapa.getPersonagens().length; j++){
                //caso não tenha personagens que pertencem a sociedade no mapa
                if(mapa.getPersonagens()[j] == null || !mapa.getPersonagens()[j].fazParteDaSociedade())
                    sum++;
                if(sum == 10){
                    System.out.println("sauron venceu");
                    gameOn = false;
                    return;
                }
            }

            for(Personagem ptemp: personagens){
                ptemp.atacar();
                ptemp.avancar();
                System.out.println(ptemp+": "+ptemp.getConstituicao());
            }
        }

    }
}
