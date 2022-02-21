package com.mycompany.examenconducir;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conector {

    public Connection conexionBase () {
        var url = "jdbc:sqlite:preguntas.db";
         try {
             var con = DriverManager.getConnection(url);
             return con;
         } catch (SQLException e) {
              JOptionPane.showInputDialog(e.toString());
              return null;
         }      
    }
}
