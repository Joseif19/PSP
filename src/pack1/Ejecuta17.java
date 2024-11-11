package pack1;

import java.io.File;
import java.io.IOException;

public class Ejecuta17 {
    public static void main(String[] args) {

        File directorio = new File("/home/usuario/IdeaProjects/PSP/out/production/PSP");

        ProcessBuilder pb = new ProcessBuilder("/home/usuario/.jdks/openjdk-23/bin/java", "pack1.Actividad17");

        File ficheroEntrada = new File("entrada.txt");
        File ficheroAlmacenar = new File("almacenarSalida.txt");

        try {
            pb.redirectInput(ficheroEntrada);  // Entrada desde fichero
            pb.redirectOutput(ficheroAlmacenar);  // Salida estándar a fichero
            pb.redirectError(ficheroAlmacenar);   // Error también redirigido al mismo fichero

            Process process = pb.start();

            int exitCode = process.waitFor();
            System.out.println("El proceso ha terminado con el código: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
