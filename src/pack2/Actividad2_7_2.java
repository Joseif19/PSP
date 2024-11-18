package pack2;

public class Actividad2_7_2 extends Thread{

    private static int contador = 0;

    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            incrementarContador();
        }
    }

    // Metodo sincronizado para incrementar el contador
    private synchronized static void incrementarContador() {
        contador++;
    }

    public static void main(String[] args) {
        // Crear los hilos uno por uno
        Actividad2_7_2 hilo1 = new Actividad2_7_2();
        Actividad2_7_2 hilo2 = new Actividad2_7_2();
        Actividad2_7_2 hilo3 = new Actividad2_7_2();
        Actividad2_7_2 hilo4 = new Actividad2_7_2();
        Actividad2_7_2 hilo5 = new Actividad2_7_2();

        // Iniciar los hilos uno por uno
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();

        // Esperar a que todos los hilos terminen
        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
            hilo4.join();
            hilo5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Mostrar el valor final del contador
        System.out.println("Contador sincronizado: " + contador);
    }

    //ahora que tenemos el metodo synchronized ya no debe ocurrir el problema que pasaba en la Actividad2_7_1, ya que este metodo asegura que solo un hilo entre a la variable

}
