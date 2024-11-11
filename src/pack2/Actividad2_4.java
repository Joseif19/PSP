//package pack2;
//
//import java.util.Scanner;
//
//public class Actividad2_4 {
//
//    public static void main(String[] args) {
//        MyHilo hilo = new MyHilo();
//        hilo.start(); // Iniciar el hilo
//
//        Scanner scanner = new Scanner(System.in);
//        String input;
//
//        System.out.println("Introduce 'S' para suspender, 'R' para reanudar, '*' para finalizar:");
//
//        do {
//            input = scanner.nextLine();
//            if (input.equalsIgnoreCase("S")) {
//                hilo.Suspende(); // Suspender el hilo
//                System.out.println("Hilo suspendido.");
//            } else if (input.equalsIgnoreCase("R")) {
//                hilo.Reanuda(); // Reanudar el hilo
//                System.out.println("Hilo reanudado.");
//            }
//        } while (!input.equals("*")); // Termina cuando se introduce '*'
//
//        hilo.interrupt(); // Finalizar el hilo
//        System.out.println("Valor final del contador: " + hilo.getContador());
//        System.out.println("Programa finalizado.");
//        scanner.close();
//    }
//
//
//
//}
