package com.uno;

import com.uno.cartas.Baralho;
import com.uno.telas.Telas;
import com.uno.utils.Utils;

public class Main {

    public static void main(String[] args) {
        Utils.baralho = new Baralho(false);

        Telas.telaPrincipal();
    }
}
