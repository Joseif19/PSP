package pack3;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Actividad3_1 {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java pack3.Actividad3_1 <nombre_de_maquina_o_direccion_IP>");

            return;
        }

        String hostOrIp = args[0];

        try {
            InetAddress address = InetAddress.getByName(hostOrIp);

            System.out.println("Información sobre: " + hostOrIp);
            System.out.println("Nombre de host: " + address.getHostName());
            System.out.println("Dirección IP: " + address.getHostAddress());
            System.out.println("¿Es local? " + address.isLoopbackAddress());
            System.out.println("¿Es alcanzable? " + address.isReachable(5000));
        } catch (UnknownHostException e) {
            System.out.println("Error: No se pudo resolver la máquina o dirección IP: " + hostOrIp);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    //para poder verlo desde la terminal hay que irse a la carpeta /src y poner el siguiente comando: java pack3.Actividad3_1 google.com  (google.com es un ejemplo)

}
