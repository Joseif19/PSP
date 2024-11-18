package pack2;

public class Actividad2_7_3 implements Runnable{

    private static int contador = 0;

    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            contador++;
        }
    }

    public static void main(String[] args) {
        Thread[] hilos = new Thread[5];

        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(new Actividad2_7_3());
            hilos[i].start();
        }

        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Contador Runnable: " + contador);
    }

    //ahora usando Runnable y sin sincronizar, ocurre lo mismo que en la primera actividad, que los hilos se interponen y hay veces que el contador no incrementa correctamente.

}
