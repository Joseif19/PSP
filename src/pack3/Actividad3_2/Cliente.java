package pack3.Actividad3_2;

import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        String servidorIP = "127.0.0.1";
        int puertoServidor = 11111;

        try (Socket socket = new Socket(servidorIP, puertoServidor)) {
            InetAddress direccion = socket.getInetAddress();
            int puertoServidorRemoto = socket.getPort();
            int puertoClienteLocal = socket.getLocalPort();

            System.out.println("Conectado al servidor en:");
            System.out.println("IP remota: " + direccion.getHostAddress());
            System.out.println("Puerto remoto: " + puertoServidorRemoto);
            System.out.println("Puerto local: " + puertoClienteLocal);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String mensajeServidor = in.readLine();
            System.out.println("Mensaje del servidor: " + mensajeServidor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
