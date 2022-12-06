package com.uno.cartas;

import java.util.HashSet;
import java.util.Set;

public class Baralho {
    public Set<Carta> baralho = new HashSet();

    public Baralho(){
        addCartasNormais();
        addCartasEspeciais();
        addCartasCoringa();
    }

    private void addCartasNormais(){
        for(int i=0;i<2;i++){
            for(int j=0;j<10;j++){
                Carta cartaVermelha = new CartaVermelha(Integer.toString(j), Classificacao.NORMAL.get());
                Carta cartaAmarela = new CartaAmarela(Integer.toString(j), Classificacao.NORMAL.get());
                Carta cartaVerde = new CartaVerde(Integer.toString(j),  Classificacao.NORMAL.get());
                Carta cartaAzul = new CartaAzul(Integer.toString(j), Classificacao.NORMAL.get());

                baralho.add(cartaVermelha);
                baralho.add(cartaAmarela);
                baralho.add(cartaVerde);
                baralho.add(cartaAzul);
            }
        }
    }
    private void addCartasEspeciais(){
        for(int i=0;i<2;i++){
            Carta cartaVermelhaMaisDois = new CartaVermelha("+2", Classificacao.ESPECIAL.get());
            Carta cartaAmarelaMaisDois = new CartaAmarela("+2", Classificacao.ESPECIAL.get());
            Carta cartaVerdeMaisDois = new CartaVerde("+2", Classificacao.ESPECIAL.get());
            Carta cartaAzulMaisDois = new CartaAzul("+2", Classificacao.ESPECIAL.get());

            Carta cartaVermelhaBloqueio = new CartaVermelha("Ø", Classificacao.ESPECIAL.get());
            Carta cartaAmarelaBloqueio = new CartaAmarela("Ø", Classificacao.ESPECIAL.get());
            Carta cartaVerdeBloqueio = new CartaVerde("Ø", Classificacao.ESPECIAL.get());
            Carta cartaAzulBloqueio = new CartaAzul("Ø", Classificacao.ESPECIAL.get());

            Carta cartaVermelhaInverter = new CartaVermelha("⟳", Classificacao.ESPECIAL.get());
            Carta cartaAmarelaInverter = new CartaAmarela("⟳", Classificacao.ESPECIAL.get());
            Carta cartaVerdeInverter = new CartaVerde("⟳", Classificacao.ESPECIAL.get());
            Carta cartaAzulInverter = new CartaAzul("⟳", Classificacao.ESPECIAL.get());

            baralho.add(cartaVermelhaMaisDois);
            baralho.add(cartaAmarelaMaisDois);
            baralho.add(cartaVerdeMaisDois);
            baralho.add(cartaAzulMaisDois);

            baralho.add(cartaVermelhaBloqueio);
            baralho.add(cartaAmarelaBloqueio);
            baralho.add(cartaVerdeBloqueio);
            baralho.add(cartaAzulBloqueio);

            baralho.add(cartaVermelhaInverter);
            baralho.add(cartaAmarelaInverter);
            baralho.add(cartaVerdeInverter);
            baralho.add(cartaAzulInverter);
        }
    }

    private void addCartasCoringa(){
        for(int i=0;i<2;i++){
            Carta cartaCoringa = new CartaCoringa("coringa", Classificacao.ESPECIAL.get());
            Carta cartaCoringaMaisQuatro = new CartaCoringa("+4", Classificacao.ESPECIAL.get());

            baralho.add(cartaCoringa);
            baralho.add(cartaCoringaMaisQuatro);
        }
    }
}
