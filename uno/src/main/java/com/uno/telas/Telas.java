package com.uno.telas;

import com.uno.cartas.Baralho;
import com.uno.cartas.Classificacao;
import com.uno.jogador.Jogador;
import com.uno.Main;
import com.uno.cartas.Carta;
import com.uno.utils.Utils;
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
        Utils.clear();

        boolean opcaoInvalida = true;

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
            Baralho baralho = new Baralho(true);

            for(int j=0;j<5;j++){
                baralho.baralho.add(Main.puxarCartaDoBaralhoPrincipal());
            }

            Jogador jogador = new Jogador(i,nome, baralho);
            Main.jogadores.add(jogador);
        }

        telaJogo();
    }

    private static void telaJogo(){

        Main.cartaRodada = Main.baralho.puxarCartaNormalDoBaralho();

        while(!Main.vitoria){
            rodada(Main.jogadorAtual);
        }

        telaVitoria();
    }

    private static void rodada(int indiceJogador){
        boolean opcaoInvalida = true;
        List<Jogador> jogadores = Main.jogadores;
        String mensagem = "\nEscolha uma de suas cartas: ";

        while(opcaoInvalida){
            Utils.clear();
            System.out.println("─────────────────────────────────────────────");
            System.out.println("  CARTA DA RODADA             ");
            System.out.println("  "+Main.cartaRodada.getCor()+" - "+Main.cartaRodada.getValor());
            System.out.println("─────────────────────────────────────────────");
            for(Jogador jogador:jogadores){
                if(jogador.getBaralho().baralho.size()>1){
                    System.out.println("  "+jogador.getNome()+": "+jogador.getBaralho().baralho.size()+" cartas");
                } else {
                    System.out.println("  "+jogador.getNome()+": "+jogador.getBaralho().baralho.size()+" carta (UNO)");
                }
            }
            System.out.println("─────────────────────────────────────────────");

            Jogador jogador = Main.jogadores.get(indiceJogador);
            int numeroCartas = jogador.getBaralho().baralho.size();
            System.out.println("Vez de ["+jogador.getNome()+"] fazer a sua jogada!");
            System.out.println("\n      |Cor|        |Valor|");

            for(int indiceCarta = 0; indiceCarta<numeroCartas; indiceCarta++){
                Carta carta = jogador.getBaralho().baralho.get(indiceCarta);
                System.out.print("("+(indiceCarta+1)+") - "+carta.getCor()+" - "+carta.getValor());
                if(cartaJogavel(carta, Main.cartaRodada)){
                    System.out.print(" [pode jogar]\n");
                } else {
                    System.out.print("\n");
                }
            }

            boolean verificaCartas = jogador.getBaralho().baralho.stream().anyMatch(c -> cartaJogavel(c, Main.cartaRodada));

            if(verificaCartas){
                System.out.print(mensagem);
                int opcao;

                try{
                    opcao = Integer.parseInt(Utils.scanner.next());
                    if(opcao >= 1 && opcao <= numeroCartas){
                        Carta cartaEscolhida = jogador.getBaralho().baralho.get(opcao-1);

                        if(cartaJogavel(cartaEscolhida, Main.cartaRodada)){
                            Main.cartaRodada = cartaEscolhida;
                            jogador.getBaralho().baralho.remove(opcao-1);

                            acaoCartasEspeciais(cartaEscolhida);

                            opcaoInvalida = false;
                        } else {
                            mensagem = "\n(!) Esta carta não pode ser jogada!\n\nEscolha novamente uma de suas cartas: ";
                        }
                    } else {
                        mensagem = "\n(!) O valor digitado deve estar entre 1 e "+numeroCartas+"!\n\nEscolha novamente uma de suas cartas: ";
                    }
                } catch (NumberFormatException e){
                    mensagem = "\n(!) O valor digitado deve estar entre 1 e "+numeroCartas+"!\n\nEscolha novamente uma de suas cartas: ";
                }

            } else {
                System.out.println("\n(!) OPA! Você não tem nenhuma carta que possa jogar!\nSendo assim, você deve puxar uma carta e passar a vez!\n\nDigite um caractere para continuar: ");
                jogador.getBaralho().baralho.add(Main.puxarCartaDoBaralhoPrincipal());
                Utils.scanner.next();
                opcaoInvalida = false;
            }
        }

        int quantidadeCartas = jogadores.get(indiceJogador).getBaralho().baralho.size();

        if(quantidadeCartas==0){
            Main.vitoria=true;
            Main.nomeGanhador = jogadores.get(indiceJogador).getNome();
        } else {
            proximoJogador();
        }
    }


    private static void telaRegras(){
        Utils.clear();
        System.out.println("┌──────────────────────────────────────────────────┐");
        System.out.println("│  REGRAS                                          │");
        System.out.println("│                                                  │");
        System.out.println("│  1. O jogo suporta de 2 a 4 jogadores            │");
        System.out.println("│  2. Cada jogador começa com 5 cartas             │");
        System.out.println("│  3. Só poderá jogar se no baralho do jogador     │");
        System.out.println("│     tiver alguma carta da mesma cor ou valor     │");
        System.out.println("│     da carta da rodada                           │");
        System.out.println("│  4. Se o jogador não possuir uma carta que possa │");
        System.out.println("│     jogar, será obrigado a puxar uma carta do    │");
        System.out.println("│     baralho e passar a vez                       │");
        System.out.println("│  5. Haverão cartas coringas que poderão ser      │");
        System.out.println("│     usadas independente da cor ou valor da carta │");
        System.out.println("│     da rodada                                    │");
        System.out.println("│  6. Ao usar a carta de bloqueio o próximo        │");
        System.out.println("│     jogador da fila não poderá jogar na rodada   │");
        System.out.println("│  7. Ao usar a carta de inverter o sentido do     │");
        System.out.println("│     jogo irá mudar de sentido horário para       │");
        System.out.println("│     anti-horário e visse versa                   │");
        System.out.println("└──────────────────────────────────────────────────┘");
        System.out.println("Digite um caractere para voltar para a tela inicial: ");
        Utils.scanner.next();
        Utils.clear();
        telaPrincipal();
    }

    private static void telaVitoria(){
        Utils.clear();
        System.out.println("──────────────────────────────────────────────────────");
        System.out.println("  "+Main.nomeGanhador+" venceu o jogo! parabéns!                                          ");
        System.out.println("──────────────────────────────────────────────────────\n\n\n\n\n\n");
    }

    private static boolean cartaJogavel(Carta carta, Carta cartaRodada){
        return cartaRodada.getClassificacao().equals(Classificacao.CORINGA.get()) ||
                carta.getCor().equals(cartaRodada.getCor()) ||
                carta.getValor().equals(cartaRodada.getValor()) ||
                carta.getClassificacao().equals(Classificacao.CORINGA.get());
    }

    private static void acaoCartasEspeciais(Carta cartaEscolhida){

        if(cartaEscolhida.getValor().equals("inverter")){
            Main.sentidoHorario = !Main.sentidoHorario;

        } else if(cartaEscolhida.getValor().equals("bloqueio")){
            proximoJogador();

        } else if(cartaEscolhida.getValor().equals("+2")){
            int indiceProximoJogador;

            if(Main.sentidoHorario){
                indiceProximoJogador = Main.transformarIndice(Main.jogadorAtual+1);
            } else {
                indiceProximoJogador = Main.transformarIndice(Main.jogadorAtual-1);
            }
            Jogador proximoJogador = Main.jogadores.get(indiceProximoJogador);
            for(int i=0;i<2;i++){
                proximoJogador.getBaralho().baralho.add(Main.puxarCartaDoBaralhoPrincipal());
            }
        } else if(cartaEscolhida.getValor().equals("+4")){
            int indiceProximoJogador;

            if(Main.sentidoHorario){
                indiceProximoJogador = Main.transformarIndice(Main.jogadorAtual+1);
            } else {
                indiceProximoJogador = Main.transformarIndice(Main.jogadorAtual-1);
            }
            Jogador proximoJogador = Main.jogadores.get(indiceProximoJogador);
            for(int i=0;i<4;i++){
                proximoJogador.getBaralho().baralho.add(Main.puxarCartaDoBaralhoPrincipal());
            }
        }
    }

    private static void proximoJogador(){
        if(Main.sentidoHorario){
            Main.jogadorAtual = Main.transformarIndice(Main.jogadorAtual+1);
        } else {
            Main.jogadorAtual = Main.transformarIndice(Main.jogadorAtual-1);
        }
    }
}
