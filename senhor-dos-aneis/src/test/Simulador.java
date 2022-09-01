package test;

import interfaces.classes.Arqueiro;
import interfaces.classes.Guerreiro;
import interfaces.classes.Mago;
import personagens.personagem_base.Personagem;

public class Simulador {

    private Mapa mapa;
    public Simulador(Mapa mapa){
        this.mapa = mapa;
    }

    public void simular(){
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


    public void simular2(){
        boolean gameOver = false;
        Personagem p;
        while(!gameOver){

            for(Personagem personagem: mapa.getPersonagens()){
                if(personagem.getConstituicao() <= 0)
                    mapa.getPersonagens()[mapa.buscarPosicao(personagem)] = null;

                personagem.atacar();
                personagem.avancar();
                System.out.println(personagem+": "+ (personagem.getConstituicao()));
                System.out.println(mapa.exibir());

            }
            //vitoria sociedade do anel
            if(mapa.buscarCasa(9) != null && mapa.buscarCasa(9).fazParteDaSociedade()){
                System.out.println("Vitoria da sociedade do anel");
                gameOver = true;
            }
            //vitoria saruman
            int sum= 0;
            for(int j = 0; j < mapa.getPersonagens().length; j++){
                if(mapa.getPersonagens()[j] == null || !mapa.getPersonagens()[j].fazParteDaSociedade())
                    sum++;
                if(sum == 10){
                    System.out.println("sauron venceu");
                    gameOver = true;
                }
            }

        }
    }
}
