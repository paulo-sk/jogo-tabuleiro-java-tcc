package test;

import exceptions.PersonagemJaEstaNoMapaException;
import exceptions.PersonagemNaoEncontradoNoMapaException;
import exceptions.PosicaoOcupadaException;
import exceptions.SauronDominaOMundoException;
import org.testng.Assert;
import org.testng.annotations.Test;
import personagens.*;

public class Testes {
    @Test
    public void deveVencerSociedadeQuandoAragornELegolasBatalharemContraOrcEGoblim() throws PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException, PersonagemJaEstaNoMapaException, SauronDominaOMundoException {
        // Início:  "|A|L| | | | | |O| |M|"
        String resultadoEsperado = "| | | | |A| | | | |L|";

        Mapa mapa = new Mapa();

        Aragorn aragorn = new Aragorn(mapa);
        Legolas legolas = new Legolas(mapa);
        Orc orc = new Orc(mapa);
        Goblim goblim = new Goblim(mapa);

        Simulador simulador = new Simulador(mapa);

        mapa.inserir(0, aragorn);
        mapa.inserir(1, legolas);
        mapa.inserir(7, orc);
        mapa.inserir(9, goblim);

        simulador.simular();
        System.out.println(mapa.exibir());

        Assert.assertEquals(resultadoEsperado, mapa.exibir());
    }

    @Test(expectedExceptions = SauronDominaOMundoException.class)
    public void deveLancarSauronDominaOMundoExceptionQuandoInimigosDerrotaremMembrosDaSociedade()
            throws PosicaoOcupadaException, SauronDominaOMundoException, PersonagemNaoEncontradoNoMapaException, PersonagemJaEstaNoMapaException {
        // Início: "|A| |I| | | | |U|O|G|"
        // Fim:    "| | | | | | |O|M| | |"
        Mapa mapa = new Mapa();

        Aragorn aragorn = new Aragorn(mapa);
        Gimli gimli = new Gimli(mapa);
        Urukhai urukhai = new Urukhai(mapa);
        Orc orc = new Orc(mapa);
        Goblim goblim = new Goblim(mapa);

        Simulador simulador = new Simulador(mapa);

        mapa.inserir(0, aragorn);
        mapa.inserir(2, gimli);
        mapa.inserir(7, urukhai);
        mapa.inserir(8, orc);
        mapa.inserir(9, goblim);

        simulador.simular();

    }

    @Test
    public void deveVencerSociedadeQuandoGandalfBatalharSozinhoContraSaruman()
            throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, SauronDominaOMundoException, PersonagemNaoEncontradoNoMapaException {
        // Início:  "|G| | | | | | | | |S|"
        String resultadoEsperado = "| | | | | | | | | |G|";
        Mapa mapa = new Mapa();

        Gandalf gandalf = new Gandalf(mapa);
        Saruman saruman = new Saruman(mapa);

        Simulador simulador = new Simulador(mapa);

        mapa.inserir(0, gandalf);
        mapa.inserir(9, saruman);
        simulador.simular();

        Assert.assertEquals(resultadoEsperado, mapa.exibir());
    }

    @Test(expectedExceptions = SauronDominaOMundoException.class)
    public void deveLancarSauronDominaOMundoExceptionQuandoLegolasBatalharSozinhoContraOrcEUrukhai()
            throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, SauronDominaOMundoException, PersonagemNaoEncontradoNoMapaException {
        // Início:  "|L| | | | | | | |U|O|"
        // Fim:     "| | | | | |U| | | | |";
        Mapa mapa = new Mapa();
        Legolas legolas = new Legolas(mapa);
        Orc orc = new Orc(mapa);
        Urukhai urukhai = new Urukhai(mapa);

        Simulador simulador = new Simulador(mapa);

        mapa.inserir(0, legolas);
        mapa.inserir(8, urukhai);
        mapa.inserir(9, orc);
        simulador.simular();
    }

    @Test(expectedExceptions = SauronDominaOMundoException.class)
    public void deveLancarSauronDominaOMundoExceptionQuandoBoromirBatalharSozinhoContraUrukhai()
            throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, SauronDominaOMundoException, PersonagemNaoEncontradoNoMapaException {
        // Início:  "|B| | | | | | | | |U|"
        // Fim:     "| | | | |U| | | | | |";
        Mapa mapa = new Mapa();
        Boromir boromir = new Boromir(mapa);
        Urukhai urukhai = new Urukhai(mapa);

        Simulador simulador = new Simulador(mapa);

        mapa.inserir(0, boromir);
        mapa.inserir(9, urukhai);
        simulador.simular();
    }

    @Test(expectedExceptions = PosicaoOcupadaException.class)
    public void deveLancarPosicaoOcupadaException()
            throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, SauronDominaOMundoException, PersonagemNaoEncontradoNoMapaException {
        Mapa mapa = new Mapa();
        Boromir boromir = new Boromir(mapa);
        Urukhai urukhai = new Urukhai(mapa);

        mapa.inserir(0, boromir);
        mapa.inserir(0, urukhai);
    }

    @Test(expectedExceptions = PersonagemJaEstaNoMapaException.class)
    public void deveLancarPersonagemJaEstaNoMapException()
            throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, SauronDominaOMundoException, PersonagemNaoEncontradoNoMapaException {

        Mapa mapa = new Mapa();
        Urukhai urukhai = new Urukhai(mapa);
        mapa.inserir(0, urukhai);
        mapa.inserir(2, urukhai);
    }

    @Test(expectedExceptions = PersonagemNaoEncontradoNoMapaException.class)
    public void deveLancarPersonagemNaoEncontradoExeption()
            throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, SauronDominaOMundoException, PersonagemNaoEncontradoNoMapaException {

        Mapa mapa = new Mapa();
        Boromir boromir = new Boromir(mapa);
        mapa.buscarPosicao(boromir);

    }

}
