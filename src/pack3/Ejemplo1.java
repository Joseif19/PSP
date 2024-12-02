package pack3;

import java.net.*;

public class Ejemplo1 {
    public static void main(String[] args) {
        InetAddress dir = null;
        System.out.println("=============================");
        System.out.println("Salida para LocalHost: ");
        try{
            dir = InetAddress.getByName("localhost");
            pruebaMetodos(dir);

            System.out.println("=============================");
            System.out.println("Salida para una url: ");

            dir = InetAddress.getByName("www.google.es");
            pruebaMetodos(dir);

            System.out.println("\tDirecciones IP para: " + dir.getHostAddress());
            InetAddress[] direcciones = InetAddress.getAllByName(dir.getHostName());

            for(int i = 0; i < direcciones.length; i++) {
                System.out.println("\t\t" + direcciones[i].toString());
            }
            System.out.println("=============================");

        }catch(UnknownHostException e1){
            e1.printStackTrace();
        }
    }

    private static void pruebaMetodos(InetAddress dir){
        System.out.println("\tMétodo getByName(): " + dir);
        InetAddress dir2;
        try{
            dir2 = InetAddress.getLocalHost();
            System.out.println("\tMétodo getLocalHost(): " + dir2);
        }catch(UnknownHostException e){
            e.printStackTrace();
        }

        System.out.println("\tMétodo getHostName(): " + dir.getHostName());
        System.out.println("\tMétodo getHostAddress(): " + dir.getHostAddress());
        System.out.println("\tMétodo toString(): " + dir.toString());
        System.out.println("\tMétodo getCanonicalHostName(): " + dir.getCanonicalHostName());

    }

}
