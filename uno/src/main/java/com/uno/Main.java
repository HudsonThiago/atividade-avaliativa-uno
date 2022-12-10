package com.uno;

import com.uno.cartas.Baralho;
import com.uno.cartas.Carta;
import com.uno.jogador.Jogador;
import com.uno.telas.Telas;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int opcao = 0;
    public static int numeroJogadores = 0;
    public static int jogadorAtual = 0;
    public static boolean vitoria = false;
    public static boolean sentidoHorario = true;
    public static String nomeGanhador;
    public static Baralho baralho;
    public static Carta cartaRodada;
    public static List<Jogador> jogadores = new ArrayList<>();

    public static void main(String[] args) {
        baralho = new Baralho(false);

        Telas.telaPrincipal();
    }

    public static Carta puxarCartaDoBaralhoPrincipal(){
        return baralho.puxarCartaDoBaralho();
    }

    public static int transformarIndice(int indiceAtual){
        int retornoIndiceAtual = indiceAtual;
        if(indiceAtual<0){
            retornoIndiceAtual=indiceAtual+jogadores.size();
        } else if(indiceAtual>jogadores.size()-1){
            retornoIndiceAtual=indiceAtual%jogadores.size();
        }
        return retornoIndiceAtual;
    }
}
