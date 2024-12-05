package pack3.Actividad3_2;

import java.io.*;
import java.net.*;

public class Servidor {

    public static void main(String[] args) {
        int port = 11111;
        try (ServerSocket socketServidor = new ServerSocket(port)) {
            System.out.println("Servidor escuchando en el puerto: " + port);
            for (int i = 1; i <= 2; i++) {
                Socket socketCliente = socketServidor.accept();
                System.out.println("Cliente nº" + i + " conectado.");

                InetAddress direccionCliente = socketCliente.getInetAddress();
                int puertoCliente = socketCliente.getPort();
                int puertoLocal = socketCliente.getLocalPort();

                System.out.println("Cliente " + i + " - IP remota: " + direccionCliente.getHostAddress() +
                        ", Puerto remoto: " + puertoCliente +
                        ", Puerto local: " + puertoLocal);

                PrintWriter pw = new PrintWriter(socketCliente.getOutputStream(), true);
                pw.println("Conexión aceptada. IP remota: " + direccionCliente.getHostAddress() +
                        ", Puerto remoto: " + puertoCliente);

                socketCliente.close();
            }
            System.out.println("Servidor cerrado.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
