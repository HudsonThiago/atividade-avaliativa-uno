package com.uno;

import com.uno.cartas.Baralho;
import com.uno.cartas.Carta;
import com.uno.cartas.CartaCoringa;
import com.uno.telas.Telas;
import jdk.jshell.execution.Util;

import java.util.Set;

public class Main {
    public static int opcao = 0;
    public static int numeroJogadores;


    public static void main(String[] args) {
        Baralho baralho = new Baralho();

        Telas.mainScreen();
        System.out.println(opcao);

    }
}
