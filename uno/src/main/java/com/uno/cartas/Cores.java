package com.uno.cartas;

public enum Cores {

    VERMELHO("#FF0000"), VERDE("#00FF00"), AMARELO("#000000"), AZUL("#0000FF"), CORINGA("FF00FF");

    private String cor;

    Cores(String cor) {
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }

}