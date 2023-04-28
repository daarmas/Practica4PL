package org.example;

public class Token {
    private String idToken;
    private int[] lexema;

    public Token(String idToken, int[] lexema) {
        this.idToken=idToken;
        this.lexema=lexema;
    }

    public String getId() {
        return idToken;
    }

    public int[] getLexema() {
        return lexema;
    }
}
