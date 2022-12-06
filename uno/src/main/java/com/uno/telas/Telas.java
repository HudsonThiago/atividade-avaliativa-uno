package com.uno.telas;

import com.uno.Main;
import com.uno.utils.Utils;

public class Telas {
    public static void mainScreen(){
        boolean opcaoInvalida = true;

        while(opcaoInvalida){
            printMainScreen();
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
            gameScreen();
        } else if(Main.opcao == 2){
            ruleScreen();
        }
    }
    private static void printMainScreen() {
        System.out.println("┌───────────────────────────────────────┐");
        System.out.println("│  UNO                                  │");
        System.out.println("│  (1) - JOGAR                          │");
        System.out.println("│  (2) - REGRAS                         │");
        System.out.println("│  (3) - SAIR                           │");
        System.out.println("└───────────────────────────────────────┘");
        System.out.print("Digite o número da opção: ");
    }

    private static void gameScreen(){
        Utils.clear();
        boolean opcaoInvalida = true;

        while(opcaoInvalida){

            System.out.println("┌───────────────────────────────────────┐");
            System.out.println("│  SELEÇÃO DE JOGADORES                 │");
            System.out.println("└───────────────────────────────────────┘");
            System.out.print("Digite o número de jogadores: ");

            try{
                Main.opcao = Integer.parseInt(Utils.scanner.next());
            } catch (NumberFormatException e){
                System.out.println("\n(!) OPÇÃO INVÁLIDA! TENTE NOVAMENTE!\n");
            } finally {
                if(Main.opcao >= 2 && Main.opcao <= 4){
                    opcaoInvalida = false;
                } else {
                    Utils.clear();
                    System.out.println("\n(!) Devem ter no mínimo 2 jogadores e no máximo 4 jogadores!\n");
                }
            }
        }

    }
    private static void ruleScreen(){
        Utils.clear();
        System.out.println("");
    }
}
