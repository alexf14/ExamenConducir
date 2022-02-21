package com.mycompany.examenconducir;

public class RespuestaErronea {

    private String respuesta;
    private int id_pregunta;

    public RespuestaErronea(String respuesta, int id_pregunta) {
        this.respuesta = respuesta;
        this.id_pregunta = id_pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public int getId_pregunta() {
        return id_pregunta;
    }

    public void setId_pregunta(int id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

}
