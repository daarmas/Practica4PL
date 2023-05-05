package org.example;

public class Main {
    public static void main(String[] args) {
        boolean [] estFinales = {false, true, true, true, false, true, false, true, true};
        int [][] matriz = {{1, 2, 3}, {4, 5, -1}, {}};
        AutomataFinitoMatriz afm = new AutomataFinitoMatriz(9,3, estFinales, matriz);
    }
}