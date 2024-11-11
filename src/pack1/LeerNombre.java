package pack1;
import java.io.*;
public class LeerNombre {
    public static void main(String[] args) throws IOException{

        if(args.length <= 0) {
            System.err.println("No hay argumentos.");
            System.exit(-1);
        }else {
            System.out.println("Nombre: " + args[0]);
            System.exit(1);
        }


    }

}
