package pack2;

public class Actividad2_7_4 implements Runnable{

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
        Thread[] hilos = new Thread[5];

        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(new Actividad2_7_4());
            hilos[i].start();
        }

        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Contador Runnable sincronizado: " + contador);
    }

    //ahora que estan sincronizados no debe ocurrir ningun problema tampoco

}
