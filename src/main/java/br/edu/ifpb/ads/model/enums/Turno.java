package br.edu.ifpb.ads.model.enums;

public enum Turno {
    
    MANHA("Manhã"),
    TARDE("Tarde"),
    NOITE("Noite");

    Turno(String turno) {
        this.turno = turno;
    }

    private String turno;

    public String getTurno() {
        return turno;
    }

}
