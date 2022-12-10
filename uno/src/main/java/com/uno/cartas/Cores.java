package com.uno.cartas;

public enum Cores {

    VERMELHO("[VERMELHO]"), VERDE("[VERDE]   "), AMARELO("[AMARELO] "), AZUL("[AZUL]    "), CORINGA("[COLORIDO]");

    private String cor;

    Cores(String cor) {
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }

}