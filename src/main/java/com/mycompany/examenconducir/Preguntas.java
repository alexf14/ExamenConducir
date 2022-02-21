package com.mycompany.examenconducir;

public class Preguntas {

    private int id;
    private String pregunta;

    public Preguntas(int id, String pregunta) {
        this.id = id;
        this.pregunta = pregunta;
    }

    public int getId() {
        return id;
    }

    public String getPregunta() {
        return pregunta;
    }   
}
