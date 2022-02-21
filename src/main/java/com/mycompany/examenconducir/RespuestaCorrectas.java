package com.mycompany.examenconducir;

public class RespuestaCorrectas {
    private String respuesta;
    private int id_pregunta;

    public RespuestaCorrectas(String respuesta, int id_pregunta) {
        this.respuesta = respuesta;
        this.id_pregunta = id_pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public int getId_pregunta() {
        return id_pregunta;
    }
    
}
