package pack3.Actividad3_3;

import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        final String host = "localhost";
        final int puerto = 11111;

        try (Socket socket = new Socket(host, puerto)) {
            System.out.println("Conectado al servidor en " + host + ":" + puerto);

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

            String mensajeServidor = br.readLine();
            System.out.println("Mensaje recibido del servidor: " + mensajeServidor);

            String mensajeMinusculas = mensajeServidor.toLowerCase();
            System.out.println("Enviando el mensaje en minúsculas: " + mensajeMinusculas);
            pw.println(mensajeMinusculas);

            System.out.println("Conexión cerrada.");
        } catch (IOException e) {
            System.err.println("Error en el cliente: " + e.getMessage());
        }
    }
}
