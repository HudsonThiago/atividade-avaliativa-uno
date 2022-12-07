package com.uno;

import com.uno.cartas.Baralho;
import com.uno.cartas.Carta;
import com.uno.cartas.CartaCoringa;
import com.uno.telas.Telas;
import com.uno.utils.Utils;
import jdk.jshell.execution.Util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static int opcao = 0;
    public static int numeroJogadores = 0;
    public static Baralho baralho;
    public static boolean vitoria = false;
    public static List<Jogador> jogadores = new ArrayList<>();

    public static void main(String[] args) {
        baralho = new Baralho();

        Telas.telaPrincipal();

    }
}
