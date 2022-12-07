package com.uno;

import com.uno.cartas.Baralho;
import com.uno.cartas.Carta;

import java.util.List;

public class Jogador {

    private int posicao;
    private String nome;
    private List<Carta> baralho;

    public Jogador(int posicao, String nome, List<Carta> baralho){
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

    public List<Carta> getBaralho(){
        return baralho;
    }
}
