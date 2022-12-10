package com.uno.jogador;

import com.uno.cartas.Baralho;
import com.uno.cartas.Carta;

import java.util.List;

public class Jogador {

    private int posicao;
    private String nome;
    private Baralho baralho;

    public Jogador(int posicao, String nome, Baralho baralho){
        this.posicao = posicao;
        this.nome = nome;
        this.baralho = baralho;
    }

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
