package org.example;

import java.util.ArrayList;
import java.util.Arrays;
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
        int posicionActual = this.posActual;
        int estadoActual=0;
        int ultEstFinal=-1;
        int ultPosFinal=-1;

        for (int i = this.posActual; i < cadena.length; i++){
            estadoActual=this.automata.funcionDeTransicion(estadoActual, cadena[i]);
            if(estadoActual==-1){
                break;
            }
            if(automata.esFinal(estadoActual)){
                ultEstFinal=estadoActual;
                ultPosFinal=i;
            }
        }

        if(ultEstFinal != -1){
            Token token = new Token(this.tokens.get(ultEstFinal), Arrays.copyOfRange(cadena,this.posActual, posicionActual));
            this.posActual = posicionActual+1;
            return token;
        }
        return null;
    }

    public boolean hasMoreTokens(){
        int posActual = this.posActual;
        int estadoActual= 0;

        for (int i = this.posActual; i < cadena.length; i++){
            estadoActual=this.automata.funcionDeTransicion(estadoActual, cadena[i]);
            if(estadoActual==-1){
                break;
            }
            if(automata.esFinal(estadoActual)){
                return true;
            }
        }

        return false;
    }

    public List<Token> getHistorico(){
        return this.historico;
    }

    public void reset(){
        this.posActual=0;
        this.historico= new ArrayList<>();
    }

    public void reset(int []cadena){
        this.cadena=cadena;
        this.posActual=0;
        this.historico= new ArrayList<>();
    }

    public void finalizarAnalisis(){
        while(this.hasMoreTokens()){
            Token t = this.nextToken();
            this.historico.add(t);
        }
    }
}
