package com.uno.telas;

import com.uno.Jogador;
import com.uno.Main;
import com.uno.cartas.Baralho;
import com.uno.cartas.Carta;
import com.uno.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Telas {

    public static void telaPrincipal(){
        boolean opcaoInvalida = true;

        while(opcaoInvalida){
            System.out.println("┌───────────────────────────────────────┐");
            System.out.println("│  UNO                                  │");
            System.out.println("│  (1) - JOGAR                          │");
            System.out.println("│  (2) - REGRAS                         │");
            System.out.println("│  (3) - SAIR                           │");
            System.out.println("└───────────────────────────────────────┘");
            System.out.print("Digite o número da opção: ");

            try{
                Main.opcao = Integer.parseInt(Utils.scanner.next());
            } catch (NumberFormatException e){
                System.out.println("\n(!) OPÇÃO INVÁLIDA! TENTE NOVAMENTE!\n");
            } finally {
                if(Main.opcao == 1 || Main.opcao == 2 || Main.opcao == 3){
                    opcaoInvalida = false;
                } else {
                    Utils.clear();
                    System.out.println("\n(!) OPÇÃO INVÁLIDA! TENTE NOVAMENTE!\n");
                }
            }
        }

        if(Main.opcao == 1){
            telaEscolherJogadores();
        } else if(Main.opcao == 2){
            telaRegras();
        }
    }

    private static void telaEscolherJogadores(){
        boolean opcaoInvalida = true;
        Utils.clear();

        while(opcaoInvalida){

            System.out.println("┌───────────────────────────────────────┐");
            System.out.println("│  SELEÇÃO DE JOGADORES                 │");
            System.out.println("└───────────────────────────────────────┘");
            System.out.print("Digite o número de jogadores: ");

            try{
                Main.numeroJogadores = Integer.parseInt(Utils.scanner.next());
            } catch (NumberFormatException e){
                System.out.println("\n(!) OPÇÃO INVÁLIDA! TENTE NOVAMENTE!\n");
            } finally {
                if(Main.numeroJogadores >= 2 && Main.numeroJogadores <= 4){
                    opcaoInvalida = false;
                    System.out.println("\n");
                } else {
                    Utils.clear();
                    System.out.println("\n(!) Devem ter no mínimo 2 jogadores e no máximo 4 jogadores!\n");
                }
            }
        }

        for(int i=1;i<=Main.numeroJogadores;i++){
            System.out.print("Digite o nome do jogador "+i+": ");
            String nome = Utils.scanner.next();
            List<Carta> baralho = new ArrayList<>();

            for(int j=0;j<5;j++){
                Carta carta = Main.baralho.puxarCartaDoBaralho();
                baralho.add(carta);
            }

            Jogador jogador = new Jogador(i,nome, baralho);
            Main.jogadores.add(jogador);
        }

        telaJogo();
    }

    private static void telaJogo(){
        Utils.clear();

        int numeroJogadores = Main.numeroJogadores;
        List<Jogador> jogadores = Main.jogadores;
        Carta cartaRodada = Main.baralho.puxarCartaDoBaralho();

        System.out.println("┌───────────────────────────────────────┐");
        System.out.println("│           O JOGO COMEÇOU!             │");
        System.out.println("└───────────────────────────────────────┘\n");
        System.out.println("───────────────────────");
        System.out.println("  CARTA DA RODADA             ");
        System.out.println("  "+cartaRodada.getCor()+" - "+cartaRodada.getValor());
        System.out.println("───────────────────────\n");



        while(Main.vitoria==false){

            for(int indiceJogador=0;indiceJogador<numeroJogadores;indiceJogador++){
                Jogador jogador = jogadores.get(indiceJogador);
                System.out.println("Vez de "+jogador.getNome()+" fazer a sua jogada!");

                for(int indiceCarta = 0; indiceCarta<jogador.getBaralho().size(); indiceCarta++){
                    Carta carta = jogador.getBaralho().get(indiceCarta);
                    System.out.println("("+(indiceCarta+1)+") - "+carta.getCor()+" - "+carta.getValor());
                }
                System.out.println("\nEscolha uma de suas cartas: ");
                String opcao = Utils.scanner.next();
            }
        }
    }
    private static void telaRegras(){
        Utils.clear();
        System.out.println("");
    }

    private static void imprimirCartasDosJogadores(){
        for(int i=0;i<Main.jogadores.size();i++){
            Jogador jogador = Main.jogadores.get(i);
            System.out.println(jogador.getNome()+"\n");
            for(int j=0;j<jogador.getBaralho().size();j++){
                Carta carta = jogador.getBaralho().get(j);
                System.out.println(carta.getCor()+" - "+carta.getValor());
            }
            System.out.println("---------------------");
        }
    }
}
