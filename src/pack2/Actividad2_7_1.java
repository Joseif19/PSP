package pack2;

public class Actividad2_7_1 extends Thread{

    private static int contador = 0;

    @Override
    public void run() {
        for (int i=0 ; i<5000 ; i++) {
            contador++;
        }
    }

    public static void main(String[] args) {
        //crear los hilos uno por uno
        Actividad2_7_1 hilo1 = new Actividad2_7_1();
        Actividad2_7_1 hilo2 = new Actividad2_7_1();
        Actividad2_7_1 hilo3 = new Actividad2_7_1();
        Actividad2_7_1 hilo4 = new Actividad2_7_1();
        Actividad2_7_1 hilo5 = new Actividad2_7_1();

        //iniciar los hilos uno por uno
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();

        //esperar a que todos los hilos terminen
        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
            hilo4.join();
            hilo5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //mostrar el contador
        System.out.println("Contador: " + contador);
    }

    //el resultado esperado sería que el valor final del contador fuese 25000, ya que son 5 hilos y se incrementa 5000 veces cada uno, pero esto no siempre es así, ya que al estar compartiendo una misma variable entre 5 hilos, estos pueden interferir a la hora de incrementarla. Puede pasar que por ejemplo, a la hora de incrementar la variable compartida, dos hilos accedan a la variable al mismo tiempo y en lugar de incrementar 2 veces la variable solamente se incremente una vez.

}
