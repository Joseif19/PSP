package pack1;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Actividad15 {

    public static void main(String[] args) throws IOException {
        File directorio = new File("/home/usuario/IdeaProjects/PSP/out/production/PSP");

        ProcessBuilder pb = new ProcessBuilder("java", "NoExisto.java");

        pb.directory(directorio);

        System.out.printf("Directorio de trabajo: %s%n", pb.directory());

        Process p = pb.start();


        try {
            InputStream is = p.getInputStream();
            int c;
            while((c = is.read()) != -1) {
                System.out.print((char) c);
            }
            is.close();
        }catch(Exception e) {
            e.printStackTrace();
        }


    }

}
