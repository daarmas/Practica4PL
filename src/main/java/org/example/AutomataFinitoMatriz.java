package org.example;

public class AutomataFinitoMatriz extends AutomataFinito{

    public int[][] matriz;

    public AutomataFinitoMatriz(int num, int alfabeto, int[][] matriz) {
        super(num, alfabeto);
        this.matriz=matriz;
    }

    public AutomataFinitoMatriz(int num, int alfabeto, boolean[] finales, int[][] matriz) {
        super(num, alfabeto, finales);
        this.matriz=matriz;
    }

    @Override
    public int funcionDeTransicion(int estado, int letra) {
        return matriz[estado][letra];
    }
}
