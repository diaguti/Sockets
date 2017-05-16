/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

import java.net.*;
import java.io.*;

/**
 *
 * @author Estudiante
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            Socket cliente = serverSocket.accept();
            InputStream flujoEntrada = cliente.getInputStream();
            OutputStream flujoSalida = cliente.getOutputStream();
            
            BufferedReader lectura = new BufferedReader(new InputStreamReader(flujoEntrada));
            //true indica que inmediatamente escriba se lo mande al cliente
            PrintWriter escritura = new PrintWriter(flujoSalida, true);
            String mensajeLeido = "";
            while (true) {    
                // recibo la informacion
                mensajeLeido = lectura.readLine();
                // mensaje respuesta
                escritura.println(" ECO " + mensajeLeido);
            }
        } catch (IOException e) {
        }
    }
    
}
