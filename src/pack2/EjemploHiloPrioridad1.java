package pack2;

public class EjemploHiloPrioridad1 {

    public static void ejecutarPrueba() {
        HiloPrioridad1 h1 = new HiloPrioridad1("Hilo 1");
        HiloPrioridad1 h2 = new HiloPrioridad1("Hilo 2");
        HiloPrioridad1 h3 = new HiloPrioridad1("Hilo 3");

        h1.setPriority(Thread.MIN_PRIORITY);
        h2.setPriority(Thread.NORM_PRIORITY);
        h3.setPriority(Thread.MAX_PRIORITY);

        h1.start();
        h2.start();
        h3.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Main interrumpido");
        }

        h1.pararHilo();
        h2.pararHilo();
        h3.pararHilo();

        System.out.println("Contador de h2 (Prioridad máxima): " + h2.getContador());
        System.out.println("Contador de h1 (Prioridad mínima): " + h1.getContador());
        System.out.println("Contador de h3 (Prioridad normal): " + h3.getContador());
    }
}
