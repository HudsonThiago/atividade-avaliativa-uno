package com.uno.cartas;

public abstract class Carta {
    protected String cor;
    protected String valor;
    protected String classificacao;




    //-----------------------------------------------------------------------------------
    // [Contrutor]
    //
    // Inicia os valores das variáveis do programa (cor, valor e classificação).
    //-----------------------------------------------------------------------------------
    Carta(String valor, String cor, String classificacao){
        this.cor = cor;
        this.valor = valor;
        this.classificacao = classificacao;
    }





    //-----------------------------------------------------------------------------------
    // [GETS]
    //
    // Métodos para retornar os valores das variáveis de cada carta instanciada.
    //-----------------------------------------------------------------------------------
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
