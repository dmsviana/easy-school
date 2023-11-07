package br.edu.ifpb.ads.model.enums;

public enum Nivel {

    BASICO("Básico"),
    INTERMEDIARIO("Intermediário"),
    AVANCADO("Avançado");

    private String nivel;

    private Nivel(String nivel) {
        this.nivel = nivel;
    }

    public String getDescricao() {
        return nivel;
    }

}
