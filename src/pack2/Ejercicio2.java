package pack2;

public class Ejercicio2 implements Runnable{

    static int espera = 1000;

    public void run(){
        System.out.println("Hola mundo " + Thread.currentThread().getId());
    }

    public static void main(String[] args) throws InterruptedException {
        Ejercicio2 hilo1 = new Ejercicio2();
        Thread.sleep(Thread.currentThread().getId()*espera);
        new Thread(hilo1).start();

        Ejercicio2 hilo2 = new Ejercicio2();
        Thread.sleep(Thread.currentThread().getId()*espera);
        new Thread(hilo2).start();

        Ejercicio2 hilo3 = new Ejercicio2();
        Thread.sleep(Thread.currentThread().getId()*espera);
        new Thread(hilo3).start();

        Ejercicio2 hilo4 = new Ejercicio2();
        Thread.sleep(Thread.currentThread().getId()*espera);
        new Thread(hilo4).start();

        Ejercicio2 hilo5 = new Ejercicio2();
        Thread.sleep(Thread.currentThread().getId()*espera);
        new Thread(hilo5).start();
    }


    //Al usar el método sleep con una cantidad de tiempo que le introducimos, el hilo tardará ese tiempo en iniciarse, ya que hay una pausa entre cada uno.

}
