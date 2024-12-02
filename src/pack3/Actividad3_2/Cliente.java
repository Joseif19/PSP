package pack3.Actividad3_2;

import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        String servidorIP = "127.0.0.1"; // Cambia si el servidor está en otra máquina
        int puertoServidor = 12345;

        try (Socket socket = new Socket(servidorIP, puertoServidor)) {
            InetAddress serverAddress = socket.getInetAddress();
            int serverRemotePort = socket.getPort();
            int clientLocalPort = socket.getLocalPort();

            System.out.println("Conectado al servidor en:");
            System.out.println("IP remota: " + serverAddress.getHostAddress());
            System.out.println("Puerto remoto: " + serverRemotePort);
            System.out.println("Puerto local: " + clientLocalPort);

            // Leer mensaje del servidor
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverMessage = in.readLine();
            System.out.println("Mensaje del servidor: " + serverMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
