package pack3.Actividad3_4;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        final String host = "localhost";
        final int puerto = 11111;

        try (Socket socket = new Socket(host, puerto)) {
            System.out.println("Conectado al servidor en " + host + ":" + puerto);

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

            Scanner sc = new Scanner(System.in);
            System.out.print("Introduce un número: ");
            int n = sc.nextInt();

            pw.println(n);
            System.out.println("Número enviado al servidor: " + n);

            String respuestaServidor = br.readLine();
            System.out.println("Respuesta del servidor: " + respuestaServidor);

            System.out.println("Conexión cerrada.");
        } catch (IOException e) {
            System.err.println("Error en el cliente: " + e.getMessage());
        }
    }
}
