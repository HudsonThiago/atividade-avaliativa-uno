package com.uno.telas;

import com.uno.Main;
import com.uno.utils.Utils;

public class Telas {
    public static void mainScreen(){
        boolean opcaoInvalida = true;

        while(opcaoInvalida){
            printMainScreen();
            Main.opcao = Utils.scanner.next();
            if(Main.opcao.equals("1") || Main.opcao.equals("2") || Main.opcao.equals("3")){
                opcaoInvalida = false;
            } else {
                Utils.clear();
                System.out.println("\n(!) OPÇÃO INVÁLIDA! TENTE NOVAMENTE!\n");
            }
        }

        if(Main.opcao.equals("1")){
            gameScreen();
        } else if(Main.opcao.equals("2")){
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
        System.out.println("");
    }
    private static void ruleScreen(){
        Utils.clear();
        System.out.println("");
    }
}
