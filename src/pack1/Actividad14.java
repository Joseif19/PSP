package pack1;
import java.io.*;
public class Actividad14 {
    public static void main(String[] args) throws IOException {
        File directorio = new File("/home/usuario/IdeaProjects/PSP/out/production/PSP");

        ProcessBuilder pb = new ProcessBuilder("/home/usuario/.jdks/openjdk-23/bin/java", "pack1.LeerNombre", "Mi nombre es Jose");

        pb.directory(directorio);

        Process proceso = pb.start();


        try {
            InputStream is = proceso.getInputStream();
            int c;
            while((c = is.read()) != -1) {
                System.out.printf("%s",(char) c);
            }
            is.close();
        }catch(Exception e) {
            e.printStackTrace();
        }

        int exitValue;

        try {
            exitValue = proceso.waitFor();
            System.out.println("Valor de salida: " + exitValue);
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
