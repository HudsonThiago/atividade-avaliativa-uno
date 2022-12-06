package com.uno.cartas;

public enum Classificacao {

    NORMAL("normal"), ESPECIAL("especial"), CORINGA("coringa");

    private String classificacao;

    Classificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String get() {
        return classificacao;
    }

}