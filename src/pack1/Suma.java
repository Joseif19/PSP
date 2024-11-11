package pack1;

import java.io.IOException;
import java.util.Scanner;

public class Suma {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
            try{
                System.out.println("Ingrese el primer número: ");
                int num1 = sc.nextInt();
                System.out.println("Ingrese el segundo número: ");
                int num2 = sc.nextInt();

                int suma = num1 + num2;

                System.out.println("La suma es: " + suma);

            }catch (Exception e){
                System.err.println("Formato inválido");
            }







    }


}

