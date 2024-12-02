package pack3;

import java.io.*;
import java.net.*;

public class Ejemplo2urlCon {
    public static void main(String[] args) {
        try{
            URL url = new URL("http://localhost/2018/vernombre.php");
            URLConnection conexion = url.openConnection();
            conexion.setDoOutput(true);

            String cadena = "nombre=Jose María&apellidos=Iglesias Fernández";

            PrintWriter output = new PrintWriter(conexion.getOutputStream());
            output.write(cadena);
            output.close();

            BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }

            reader.close();

        }catch (MalformedURLException e){
            System.out.println("MalformedURLException: " + e);
        }catch (IOException e){
            System.out.println("IOException: " + e);
        }
    }
}
