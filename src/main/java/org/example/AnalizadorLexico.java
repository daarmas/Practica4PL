package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AnalizadorLexico {
    public AutomataFinito automata;
    public int[] cadena;
    public int posActual;
    public Map<Integer, String> tokens;
    public List<Token> historico;

    public AnalizadorLexico(int[] cadena, AutomataFinito af, Map<Integer, String> tokens){
        this.posActual=0;
        this.historico= new ArrayList<>();
        this.tokens=tokens;
        this.cadena=cadena;
        this.automata=af;
    }

    public Token nextToken(){

    }
}
