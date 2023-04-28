package org.example;

public abstract class AutomataFinito {

    public int numEstados;
    public boolean[] estadosFin;
    public int tamAlfabeto;

    public AutomataFinito(int num, int alfabeto){
        numEstados=num;
        this.tamAlfabeto=alfabeto;
        estadosFin= new boolean[num];
    }

    public AutomataFinito(int num, int alfabeto, boolean[] finales){
        this.numEstados=num;
        this.tamAlfabeto=alfabeto;
        this.estadosFin=finales;
    }

    public boolean esFinal(int estado){
        if(estado!=-1 ){
            return estadosFin[estado];
        }
        return false;
    }

    public int cierreTransicion(int estado, int[] cadena){
        int estadoActual=estado;
        for(int i: cadena){
            estadoActual = funcionDeTransicion(estadoActual, i);
            if(estadoActual==-1){
                return -1;
            }
        }
        return estadoActual;
    }

    public boolean perteneceLenguaje(int[] cadena){
        int estadoDevuelto = cierreTransicion(0, cadena);

        return esFinal(estadoDevuelto);
    }

    public abstract int funcionDeTransicion(int estado, int letra);
}
