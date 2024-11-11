package pack2;

public class Ejercicio1 extends Thread{
    @Override
    public void run() {
        System.out.println("Hola mundo desde " + getId());
    }

    public static void main(String[] args) {

        Ejercicio1 hilo1 = new Ejercicio1();
        Ejercicio1 hilo2 = new Ejercicio1();
        Ejercicio1 hilo3 = new Ejercicio1();
        Ejercicio1 hilo4 = new Ejercicio1();
        Ejercicio1 hilo5 = new Ejercicio1();

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
    }
}
