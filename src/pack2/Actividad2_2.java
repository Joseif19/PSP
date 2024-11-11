package pack2;


public class Actividad2_2 implements Runnable{

    @Override
    public void run() {
        System.out.println("Hola mundo desde " + Thread.currentThread().getId());
    }

    public static void main(String[] args) {

        Actividad2_2 hilo1 = new Actividad2_2();
        new Thread(hilo1).start();
        Actividad2_2 hilo2 = new Actividad2_2();
        new Thread(hilo2).start();
        Actividad2_2 hilo3 = new Actividad2_2();
        new Thread(hilo3).start();
        Actividad2_2 hilo4 = new Actividad2_2();
        new Thread(hilo4).start();
        Actividad2_2 hilo5 = new Actividad2_2();
        new Thread(hilo5).start();
    }
}
