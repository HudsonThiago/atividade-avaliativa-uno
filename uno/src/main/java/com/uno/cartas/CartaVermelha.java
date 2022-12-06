package com.uno.cartas;

public class CartaVermelha extends Carta {

    public CartaVermelha(String valor, String classificacao){
        super(valor, Cores.VERMELHO.getCor(), classificacao);
    }
}
