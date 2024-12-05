package pack3.Actividad3_4;

import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        final int puerto = 11111;

        try (ServerSocket socketServidor = new ServerSocket(puerto)) {
            System.out.println("Servidor en espera de conexiones en el puerto " + puerto);
            Socket socketCliente = socketServidor.accept();
            System.out.println("Cliente conectado desde: " + socketCliente.getInetAddress());

            BufferedReader br = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            PrintWriter pw = new PrintWriter(socketCliente.getOutputStream(), true);

            String mensajeCliente = br.readLine();
            System.out.println("Número recibido del cliente: " + mensajeCliente);

            try {
                int n = Integer.parseInt(mensajeCliente);
                int nCuadrado = n * n;
                System.out.println("Enviando el cuadrado del número: " + nCuadrado);
                pw.println(nCuadrado);
            } catch (NumberFormatException e) {
                System.out.println("Error: el cliente no envió un número válido.");
                pw.println("Error: no es un número válido.");
            }

            socketCliente.close();
            System.out.println("Conexión cerrada.");
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }
}
