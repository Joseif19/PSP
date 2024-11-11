package pack1;

import java.io.*;
import java.util.Scanner;

public class Actividad16 {

    public static void main(String[] args) throws Exception {

        File directorio = new File("/home/usuario/IdeaProjects/PSP/out/production/PSP");

        ProcessBuilder pb = new ProcessBuilder("/home/usuario/.jdks/openjdk-23/bin/java", "pack1.Suma");

        pb.directory(directorio);


        //iniciar el proceso
        Process proceso = pb.start();

        // Capturar entrada del usuario y enviar al proceso
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             OutputStream os = proceso.getOutputStream()) {

            //leer primer num
            System.out.print("Introduce el primer número: ");
            String num1 = br.readLine();
            os.write((num1 + "\n").getBytes());  //mando el primer num al proceso
            os.flush();  //vacía el buffer

            //leer segundo num
            System.out.print("Introduce el segundo número: ");
            String num2 = br.readLine();
            os.write((num2 + "\n").getBytes());  //madno el sgundo num al proceso
            os.flush();  //vacía el buffer
        }

        //leer entrada por teclado
        try (BufferedReader br2 = new BufferedReader(new InputStreamReader(proceso.getInputStream()))) {
            String linea;
            while ((linea = br2.readLine()) != null) {
                System.out.println(linea);  //se imprime lo que produce el proceso
            }
        }

        //gestion de errores
        try (BufferedReader br3 = new BufferedReader(new InputStreamReader(proceso.getErrorStream()))) {
            String error;
            while ((error = br3.readLine()) != null) {
                System.err.println(error);  //imprime error
            }
        }


        try {
            int exitValue = proceso.waitFor();
            System.out.println("Valor de salida del proceso: " + exitValue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
