package com.uno.jogador;

import com.uno.cartas.Baralho;
import com.uno.cartas.Carta;

import java.util.List;

public class Jogador {

    private int posicao;
    private String nome;
    private Baralho baralho;




    //-----------------------------------------------------------------------------------
    // [Contrutor]
    //
    // Inicia os valores das variáveis do programa (posicao, nome e baralho).
    //-----------------------------------------------------------------------------------
    public Jogador(int posicao, String nome, Baralho baralho){
        this.posicao = posicao;
        this.nome = nome;
        this.baralho = baralho;
    }





    //-----------------------------------------------------------------------------------
    // [GETS]
    //
    // Métodos para retornar os valores das variáveis de cada jogador instanciado.
    //-----------------------------------------------------------------------------------
    public int getPosicao(){
        return posicao;
    }

    public String getNome(){
        return nome;
    }

    public Baralho getBaralho(){
        return baralho;
    }
}
