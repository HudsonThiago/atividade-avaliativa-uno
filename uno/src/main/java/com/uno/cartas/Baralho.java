package com.uno.cartas;
import com.uno.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class Baralho {
    public List<Carta> baralho = new ArrayList<>();




    //-----------------------------------------------------------------------------------
    // [Contrutores]
    //
    // Após fazer uma instância da classe, o baralho já iniciará com 112 cartas
    // sendo: (80) cartas normais
    //        (24) cartas especiais
    //        (08) cartas coringas
    //
    // A instância também poderá ter um parâmetro booleano de 'vazio' que indica se o
    // baralho iniciará com nenhuma carta (true) ou já preenchida (false).
    //-----------------------------------------------------------------------------------
    public Baralho(){
        embaralhar();
    }

    public Baralho(boolean vazio){
        if(!vazio){
            embaralhar();
        }
    }




    //-----------------------------------------------------------------------------------
    // [embaralhar]
    //
    // adiciona na lista 'baralho' cartas normais (ex.: numéricas),
    // cartas especiais (ex.: bloqueios, inverter, etc...) e cartas coringas (ex.: +4)
    //-----------------------------------------------------------------------------------
    private void embaralhar(){
        addCartasNormais();
        addCartasEspeciais();
        addCartasCoringa();
    }




    //-----------------------------------------------------------------------------------
    // [puxarCartaDoBaralho]
    //
    // Verifica se existe cartas no baralho. Se não existir, adiciona novas cartas.
    // Logo depois, é sorteado uma carta aleatória do baralho, essa carta é removida
    // e sai como retorno da função.
    //-----------------------------------------------------------------------------------
    public Carta puxarCartaDoBaralho(){

        if(baralho.size() <= 6){
            embaralhar();
        }

        int cartaSorteada = Utils.random.nextInt(baralho.size());
        Carta carta = baralho.get(cartaSorteada);
        baralho.remove(cartaSorteada);
        return carta;
    }




    //-----------------------------------------------------------------------------------
    // [puxarCartaNormalDoBaralho]
    //
    // Semelhante ao último método, a única diferença é que retorna apenas cartas que
    // possuem o campo 'classificacao' igual a 'normal'.
    //-----------------------------------------------------------------------------------
    public Carta puxarCartaNormalDoBaralho(){

        boolean verificarCarta = true;
        int cartaSorteada;
        int contador=0;
        Carta carta = baralho.get(0);

        if(baralho.size() <= 6){
            embaralhar();
        }

        while(verificarCarta){
            cartaSorteada = Utils.random.nextInt(baralho.size());
            carta = baralho.get(cartaSorteada);

            if(carta.getClassificacao().equals("normal")){
                verificarCarta = false;
                baralho.remove(cartaSorteada);
            }
            if(contador>200){
                return carta;
            }
            contador++;
        }
        return carta;
    }




    //-----------------------------------------------------------------------------------
    // [addCartasNormais]
    //
    // Adiciona um par de cartas numéricas ao baralho. Existem números que vão de 0 a 9.
    //-----------------------------------------------------------------------------------
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




    //-----------------------------------------------------------------------------------
    // [addCartasEspeciais]
    //
    // Adiciona um par de cartas especiais ao baralho. Sendo elas: bloqueio, inverter e +2.
    //-----------------------------------------------------------------------------------
    private void addCartasEspeciais(){
        for(int i=0;i<2;i++){
            Carta cartaVermelhaMaisDois = new CartaVermelha("+2", Classificacao.ESPECIAL.get());
            Carta cartaAmarelaMaisDois = new CartaAmarela("+2", Classificacao.ESPECIAL.get());
            Carta cartaVerdeMaisDois = new CartaVerde("+2", Classificacao.ESPECIAL.get());
            Carta cartaAzulMaisDois = new CartaAzul("+2", Classificacao.ESPECIAL.get());

            Carta cartaVermelhaBloqueio = new CartaVermelha("bloqueio", Classificacao.ESPECIAL.get());
            Carta cartaAmarelaBloqueio = new CartaAmarela("bloqueio", Classificacao.ESPECIAL.get());
            Carta cartaVerdeBloqueio = new CartaVerde("bloqueio", Classificacao.ESPECIAL.get());
            Carta cartaAzulBloqueio = new CartaAzul("bloqueio", Classificacao.ESPECIAL.get());

            Carta cartaVermelhaInverter = new CartaVermelha("inverter", Classificacao.ESPECIAL.get());
            Carta cartaAmarelaInverter = new CartaAmarela("inverter", Classificacao.ESPECIAL.get());
            Carta cartaVerdeInverter = new CartaVerde("inverter", Classificacao.ESPECIAL.get());
            Carta cartaAzulInverter = new CartaAzul("inverter", Classificacao.ESPECIAL.get());

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




    //-----------------------------------------------------------------------------------
    // [addCartasCoringa]
    //
    // Adiciona um par de cartas coringas ao baralho. Sendo elas: coringa e +4.
    //-----------------------------------------------------------------------------------
    private void addCartasCoringa(){
        for(int i=0;i<4;i++){
            Carta cartaCoringa = new CartaCoringa("coringa", Classificacao.CORINGA.get());
            Carta cartaCoringaMaisQuatro = new CartaCoringa("+4", Classificacao.CORINGA.get());

            baralho.add(cartaCoringa);
            baralho.add(cartaCoringaMaisQuatro);
        }
    }
}
