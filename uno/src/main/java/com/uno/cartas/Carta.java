package com.uno.cartas;

public abstract class Carta {
    protected String cor;
    protected String valor;
    protected String classificacao;

    Carta(String valor, String cor, String classificacao){
        this.cor = cor;
        this.valor = valor;
        this.classificacao = classificacao;
    }

    public String getCor(){
        return cor;
    }

    public String getValor(){
        return valor;
    }

    public String getClassificacao(){
        return classificacao;
    }

}
