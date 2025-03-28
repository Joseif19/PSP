package pack3.Actividad3_3;

import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        final int puerto = 11111;

        try (ServerSocket socketServidor = new ServerSocket(puerto)) {
            System.out.println("Servidor en espera de conexiones en el puerto " + puerto);
            Socket socketCliente = socketServidor.accept();
            System.out.println("Cliente conectado desde: " + socketCliente.getInetAddress());

            PrintWriter pw = new PrintWriter(socketCliente.getOutputStream(), true);
            BufferedReader br = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));

            String mensajeServidor = "Buenassss Tardess";
            System.out.println("Enviando: " + mensajeServidor);
            pw.println(mensajeServidor);

            String respuesta = br.readLine();
            System.out.println("Respuesta del cliente: " + respuesta);

            socketCliente.close();
            System.out.println("Conexión cerrada.");
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }
}

