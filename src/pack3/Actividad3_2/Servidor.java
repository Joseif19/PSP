package pack3.Actividad3_2;

import java.io.*;
import java.net.*;

public class Servidor {

    public static void main(String[] args) {
        int port = 12345;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor escuchando en el puerto " + port);
            for (int i = 1; i <= 2; i++) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente " + i + " conectado.");

                InetAddress clientAddress = clientSocket.getInetAddress();
                int clientPort = clientSocket.getPort();
                int localPort = clientSocket.getLocalPort();

                System.out.println("Cliente " + i + " - IP remota: " + clientAddress.getHostAddress() +
                        ", Puerto remoto: " + clientPort +
                        ", Puerto local: " + localPort);

                // Enviar mensaje al cliente
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println("Conexión aceptada. IP remota: " + clientAddress.getHostAddress() +
                        ", Puerto remoto: " + clientPort);

                clientSocket.close();
            }
            System.out.println("Servidor cerrado.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
