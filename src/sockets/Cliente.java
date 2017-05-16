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
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Socket cliente = new Socket("localhost",8000);
            InputStream flujoEntrada = cliente.getInputStream();
            OutputStream flujoSalida = cliente.getOutputStream();
            
            BufferedReader lectura = new BufferedReader(new InputStreamReader(flujoEntrada));
            BufferedReader lecturaUsuario = new BufferedReader(new InputStreamReader(System.in));    
            PrintWriter escritura = new PrintWriter(flujoSalida, true);
            String mensajeLeido = "";
            String mensajeUsuario = "";
            while (true) {                
                System.out.println("Que mensaje desea enviar");
                mensajeUsuario = lecturaUsuario.readLine();
                escritura.println(mensajeUsuario);
                mensajeLeido = lectura.readLine();
                System.out.println("Me contestaron" + mensajeLeido);
            }
        } catch (IOException e) {
        }
    }
    
}
