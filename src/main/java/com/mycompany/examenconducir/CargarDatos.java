package com.mycompany.examenconducir;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CargarDatos {

    private static int posicionPreguntas = 0;
    private static ArrayList<Preguntas> arrayPreguntas = new ArrayList<Preguntas>();
    private static ArrayList<RespuestaCorrectas> arrayRespuestaCorrecta = new ArrayList<RespuestaCorrectas>();
    private static ArrayList<RespuestaErronea> arrayRespuestaErronea = new ArrayList<RespuestaErronea>();
    
    private static int nPreguntas = 10;
    private static int limitePreguntas = 0;
    static String devolverPregunta;
    
    public static void cargarPreguntas (){ //Este metodo carga todas las preguntas de la base de datos a un arrayList llamado arrayPreguntas
        Conector conector = new Conector();
        Preguntas preguntas;
        
        String sentencia = "select Id, Pregunta from Preguntas where Id = ?";
        String limitePreguntas = "select Id from Preguntas order by Id desc limit 1;";
        String pregunta;
        int id;
        
        PreparedStatement ps;
        ResultSet rs;
        Connection con = conector.conexionBase();
        
        try{
            ps = con.prepareStatement(limitePreguntas);
                rs = ps.executeQuery();

                if (rs.next()) {
                    CargarDatos.limitePreguntas = rs.getInt(1);
                }
        } catch (SQLException ex) {
            Logger.getLogger(CargarDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            for (int k = 1; k <= CargarDatos.limitePreguntas; k++) {    
                ps = con.prepareStatement(sentencia);

                ps.setInt(1, k);
                rs = ps.executeQuery();
                
                if (rs.next()) {
                    id = rs.getInt(1);
                    pregunta = rs.getString(2);
                    
                    preguntas = new Preguntas(id, pregunta);
                    arrayPreguntas.add(preguntas);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CargarDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void cargarRespuestaCorrecta (){ //Este metodo carga todas las respuestas correctas de la base de datos a un arrayList llamado arrayRespuestaCorrecta
        Conector conector = new Conector();

        String sentencia = "select Id_Pregunta, respuesta from RespuestasCorrectas where Id = ?";
        int id_pregunta;
        String respuestaCorrecta;
        
        PreparedStatement ps;
        ResultSet rs;
        Connection con = conector.conexionBase();     
        
        try {
  
            for (int k = 0; k <= arrayPreguntas.size(); k++) {   
                    ps = con.prepareStatement(sentencia);
                ps.setInt(1,k);
                rs = ps.executeQuery();
                
                if (rs.next()) {
                    id_pregunta = rs.getInt(1);
                    respuestaCorrecta = rs.getString(2);
                    
                    RespuestaCorrectas respuestaCorrectas = new RespuestaCorrectas(respuestaCorrecta, id_pregunta);
                    arrayRespuestaCorrecta.add(respuestaCorrectas);
                }   
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CargarDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void cargarRestpuestaErronea () {//Este metodo carga todas las preguntas de la base de datos a un arrayList llamado arrayRespuestasErroneas
        Conector conector = new Conector();

        String sentencia = "select Id_Pregunta, respuesta from RespuestasErroneas where Id = ?";
        String sentencia2 = "select Id from RespuestasErroneas order by Id desc limit 1;";
        int id_pregunta;
        int largo = 0;
        String respuestasErroneas;
        
        PreparedStatement ps;
        ResultSet rs;
        Connection con = conector.conexionBase();     
        
        try {
                ps = con.prepareStatement(sentencia2);
                rs = ps.executeQuery();
                if (rs.next()) {
                    largo = rs.getInt(1);
                }
                
            for (int k = 0; k <= largo; k++) {    
                
                ps = con.prepareStatement(sentencia);
                ps.setInt(1,k);
                rs = ps.executeQuery();

                if (rs.next()) {
                    id_pregunta = rs.getInt(1);
                    respuestasErroneas = rs.getString(2);
                    
                    RespuestaErronea respuestaErronea = new RespuestaErronea(respuestasErroneas, id_pregunta);
                    arrayRespuestaErronea.add(respuestaErronea);
                }
 
            }
        } catch (SQLException ex) {
            Logger.getLogger(CargarDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getPregunta(){// Este método es llamado por calse Test para que le devuelva una pregutna aleatoria del arrayList
        int nPreguntas = arrayPreguntas.size();
        int pregunta = (int) (Math.random()* nPreguntas);
        if(posicionPreguntas < getNumeroPregutnas()){
            if(pregunta >= arrayPreguntas.size()|| arrayPreguntas.get(pregunta) == null){
                while(pregunta >= arrayPreguntas.size()||arrayPreguntas.get(pregunta) == null){
                    pregunta = (int) (Math.random()*limitePreguntas-1);
                }
            }
            devolverPregunta = arrayPreguntas.get(pregunta).getPregunta();
            
            posicionPreguntas ++;
            
            return devolverPregunta;
        }else{
            return null;
        }
    }
    
    public boolean esCorrecta (String respuesta){// Este método comprueba si la pregunta seleccionada dentro del test es correcta
        for(int k = 0; k<arrayRespuestaCorrecta.size(); k++){
            if(arrayRespuestaCorrecta.get(k).getRespuesta().equals(respuesta)){              
                return true;
            }
        }
        
        return false;
    }
    
    public int getNumeroPregutnas (){// Este método interactua con la clase Configuración y establece el núemro de preguntas máxima que va a tener un test (por defecto la variable que lo determina esta establecida en 10)
        Configuracion conf = new Configuracion ();
        
        if(conf.getnPreguntas()>0){
            nPreguntas = conf.getnPreguntas();
        }
        
        return nPreguntas;
    }
    
    public String getRespuestaCorrecta (String pregunta){// Este método devuelve la pregutna correcta correspondiente con la pregunta que aparece en el test
        int k = 0;
        
        for(k = 0; k < arrayPreguntas.size()-1 && !arrayPreguntas.get(k).getPregunta().equals(pregunta); k++){
        }
        
        String respuesta =arrayRespuestaCorrecta.get(k).getRespuesta();
        
        return respuesta;
    }
    
    public String getRespuestaErronea (String pregunta){// Este métod devuelve una pregutna erronea al test correspondiente con la pregunta que aparece en pantalla
        int k = 0;
        
        for(k = 0; k < arrayPreguntas.size()-1 && !arrayPreguntas.get(k).getPregunta().equals(pregunta); k++){
        }
        
        int pos = arrayPreguntas.get(k).getId();
        
        for(k = 0; k < arrayRespuestaErronea.size()-1 && arrayRespuestaErronea.get(k).getId_pregunta() != pos; k++){          
        }
        
        String respuesta =arrayRespuestaErronea.get(k).getRespuesta();
        arrayRespuestaErronea.remove(k);
        
        return respuesta;
    }
    
    public int posPreguntaCorrecta (){// Este método genera una posición aleatora para la respuesta correctra dentro del test
         int pos = (int) (Math.random()* (4-1));
         
         return pos;
    }
}
